/**
 * 
 */
package com.exp.learning.mapred;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author spanwar
 *
 */
public class MaxTempMapper extends Mapper<LongWritable, Text, Text, Text>{

	enum MaxTemp{
		ERROR_LINES
	}
	
	private Text tempKey = new Text();
	private Text tempVal = new Text();
	
	protected void map(LongWritable key, Text value, Context context) 
			throws IOException, InterruptedException {
		String line = value.toString();
		String[] st = line.split(" ");
		if(st != null && st.length == 2){
			tempKey.set(st[0]);
			tempVal.set(st[1]);
			context.write(tempKey, tempVal);
		}else{
			context.getCounter(MaxTemp.ERROR_LINES).increment(1);
		}	
	}
}
