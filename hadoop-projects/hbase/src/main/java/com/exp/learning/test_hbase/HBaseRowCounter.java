/**
 * 
 */
package com.exp.learning.test_hbase;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.FirstKeyOnlyFilter;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.output.NullOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author spanwar
 *
 */
public class HBaseRowCounter extends Configured implements Tool {

	static class RowCounterMapper extends TableMapper<ImmutableBytesWritable, Result> {
		public static enum Counters { ROWS }
			
		public void map(ImmutableBytesWritable row, Result value, Context context) { 
			context.getCounter(Counters.ROWS).increment(1);
		} 
	}

	@Override
	public int run(String[] args) throws Exception { 
		if (args.length != 1) {
			System.err.println("Usage: HBaseRowCounter <tablename>");
			return -1; 
		}
			System.out.println("Starting runner");
			String tableName = args[0];
			Scan scan = new Scan(); scan.setFilter(new FirstKeyOnlyFilter());
			Job job = Job.getInstance(getConf());
			job.setJobName(getClass().getSimpleName());
			job.setJarByClass(getClass()); 
			System.out.println("Job is set1");
			TableMapReduceUtil.initTableMapperJob(tableName, scan, RowCounterMapper.class, ImmutableBytesWritable.class, Result.class, job); 
			job.setNumReduceTasks(0);
			job.setOutputFormatClass(NullOutputFormat.class);
			System.out.println("Job is set2");
			return job.waitForCompletion(true) ? 0: 1;
	}

	public static void main(String[] args) throws Exception { 
			int exitCode = ToolRunner.run(HBaseConfiguration.create(), new HBaseRowCounter(), args); 
			System.exit(exitCode);
	} 
}
