/**
 * 
 */
package com.exp.learning.mapred;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author spanwar
 * How to run: hadoop jar mreduce-api.jar com.exp.learning.mapred.MaxTemp /user/adm-spanwar/mapred/input/maxtemp/ /user/adm-spanwar/mapred/output/maxtemp/
 */
public class MaxTemp extends Configured implements Tool{

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int res = ToolRunner.run(new Configuration(), new MaxTemp(), args);
		System.exit(res);
	}
	
	public int run(String args[]) 
			throws IOException, ClassNotFoundException, InterruptedException {
		if(args.length < 2){
			System.err.println("Input and Output parameter are required");
			ToolRunner.printGenericCommandUsage(System.err);
			return -1;
		}
		System.out.println("Running MaxTemp Program");
		
		Job job = Job.getInstance(getConf(), "Max Temp Job");
		job.setJarByClass(getClass());
		job.setMapperClass(MaxTempMapper.class);
		job.setReducerClass(MaxTempReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		return job.waitForCompletion(true) ? 0 : 1;
	}

}
