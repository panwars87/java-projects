package com.exp.learning.test_hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Test class to understand HBase Java api methods
 * Source: https://hbase.apache.org/apidocs/org/apache/hadoop/hbase/client/package-summary.html
 * javac -cp `hbase classpath` App.java
 * java -cp `hbase classpath` App
 * @author spanwar
 *
 */
public class HbaseCRUD 
{
	/** Logger */
	//private static final Logger LOG = LoggerFactory.getLogger(App.class);

	private static Connection connection;
	private static String TABLE_NAME = "test_emp";
	private static String COL_FAM_PER = "personal";
	private static String COL_FAM_PROF = "professional";
	private static String[] FAMILY_ARRAY = {COL_FAM_PER,COL_FAM_PROF};

	/**
	 * Get HBase Connection
	 * Create HBase configuration and then make connection using ConnectionFactory
	 * @return
	 */
	private static Connection getConnection(){
		if (connection == null) {
			try {
				Configuration conf = HBaseConfiguration.create();
				connection = ConnectionFactory.createConnection(conf);
			} catch (Exception e) {
				System.err.println("Unable to create connection to hbase.");
				System.err.println("Exception: {}");
				e.printStackTrace();
			}
		}
		return connection;
	}

	/**
	 * Method to create table along with column families
	 * @param tableName
	 * @param columnFamily
	 * @throws Exception
	 */
	public static void createTable(String tableName, String[] columnFamily) throws Exception{
		try(Admin hadmin= getConnection().getAdmin()){
			if(hadmin.isTableAvailable(TableName.valueOf(tableName))){
				System.out.println("table already exists");
			}else {
				HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
				for(String family: columnFamily){
					tableDescriptor.addFamily(new HColumnDescriptor(family));
				}
				hadmin.createTable(tableDescriptor);
				System.out.println("create table " + tableName + " ok.");
			}
		}
	}

	/**
	 * Put -- To insert key-value combo in HBase
	 * @param tableName
	 * @param rowKey
	 * @param columnFamily
	 * @param columnName
	 * @param value
	 * @throws IOException
	 */
	public static void put(String tableName, String rowKey, String columnFamily, 
			String columnName, String value) throws IOException{
		try(Table table = getConnection().getTable(TableName.valueOf(tableName))){
			Put p = new Put(Bytes.toBytes(rowKey));
			p.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(columnName), Bytes.toBytes(value));
			table.put(p);
		}
	}

	/**
	 * Get -- To get from HBase Table based on rowkey.
	 * @param tableName
	 * @param rowKey
	 * @param columnFamily
	 * @param qualifier
	 * @throws IOException
	 */
	public static void getRow(String tableName, String rowKey, String columnFamily, String qualifier) throws IOException{
		try(Table table = getConnection().getTable(TableName.valueOf(tableName))){
			Get get = new Get(Bytes.toBytes(rowKey));
			Result r = table.get(get);
			byte[] bytearr = r.getValue(Bytes.toBytes(columnFamily), Bytes.toBytes(qualifier));
			System.out.println("Value retrieved is : "+ Bytes.toString(bytearr));
		}
	}

	/**
	 * Scan -- To get a list of all entries in a table.
	 * Family, Qualifier & Value
	 * @param tableName
	 * @throws IOException
	 */
	public static void scanRows(String tableName) throws IOException{

		Scan s = new Scan();
		s.setMaxVersions(1);
		try(Table table = getConnection().getTable(TableName.valueOf(tableName)); ResultScanner rs = table.getScanner(s)){
			for(Result r : rs){
				System.out.println("Found row : "+ r);

				for(Cell cell : r.listCells()){
					String family = Bytes.toString(CellUtil.cloneFamily(cell));
					String qualifier = Bytes.toString(CellUtil.cloneQualifier(cell));
					String value = Bytes.toString(CellUtil.cloneValue(cell));

					System.out.printf("Family : %s : Qualifier : %s : Value : %s", family, qualifier, value);
					System.out.println("");
				}

				//create Map by result and print it
				//Map<String, String> getResult =  r.listCells().stream().collect(Collectors.toMap(e -> Bytes.toString(CellUtil.cloneQualifier(e)), e -> Bytes.toString(CellUtil.cloneValue(e))));
				//getResult.entrySet().stream().forEach(e-> System.out.printf("Qualifier : %s : Value : %s", e.getKey(), e.getValue()));
				//System.out.println("");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * To delete a column family and its data
	 * @param tablename
	 * @param rowKey
	 * @param columnFamily
	 * @throws IOException
	 */
	public static void deleteColumn(String tablename, String rowKey, String columnFamily) throws IOException{
		try(Table table = getConnection().getTable(TableName.valueOf(tablename))){
			Delete del = new Delete(Bytes.toBytes(rowKey));
			del.addFamily(Bytes.toBytes(columnFamily));
			table.delete(del);
		}
		//second way to delete table column family using Admin class
		//Admin admin = getConnection().getAdmin();
		//admin.deleteColumn(TableName.valueOf(tablename), Bytes.toBytes(columnFamily));
	}

	/**
	 * Method to delete a table from database.
	 * First it will disable & then delete the table.
	 * @param tablename
	 * @throws IOException
	 */
	public static void deleteTable(String tablename) throws IOException{
		try(Admin admin = getConnection().getAdmin()){
			admin.disableTable(TableName.valueOf(tablename));
			admin.deleteTable(TableName.valueOf(tablename));
		}
	}

	public static void main( String[] args ) throws Exception
	{
		System.out.println("Creating table name : test_emp with family as personal & proffesional");
		System.out.println("---------------------------------------------------------------------");
		createTable(TABLE_NAME, FAMILY_ARRAY);

		System.out.println("Creating record for : test_emp : personal : fname");
		System.out.println("---------------------------------------------------------------------");
		put(TABLE_NAME, "empxxx1", COL_FAM_PER, "fname", "Shashant");

		System.out.println("Creating record for : test_emp : personal : lname");
		System.out.println("---------------------------------------------------------------------");
		put(TABLE_NAME, "empxxx1", COL_FAM_PER, "lname", "Panwar");

		System.out.println("Getting record for fname & lname");
		System.out.println("---------------------------------------------------------------------");
		getRow(TABLE_NAME, "empxxx1", COL_FAM_PER, "fname");
		getRow(TABLE_NAME, "empxxx1", COL_FAM_PER, "lname");
		System.out.println("---------------------------------------------------------------------");

		System.out.println("Scanning table rows");
		scanRows(TABLE_NAME);
		System.out.println("---------------------------------------------------------------------");
		
		Thread.sleep(60000);
		
		System.out.println("Deleteing table column families : "+ COL_FAM_PER);
		deleteColumn(TABLE_NAME, "empxxx1", COL_FAM_PER);
		System.out.println("---------------------------------------------------------------------");
		
		System.out.println("Deleting table from HBase db : "+ TABLE_NAME);
		deleteTable(TABLE_NAME);
	}
}
