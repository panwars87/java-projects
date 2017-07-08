package com.exp.learning.mapred;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author spanwar
 * How to Run: hadoop jar mreduce-api.jar com.exp.learning.mapred.AlphabetTest -D mapred.reduce.tasks=3 /user/adm-spanwar/mapred/input/alphabet/ /user/adm-spanwar/mapred/output/alphabet/
 *
 */
public class AlphabetTest extends Configured implements Tool{

	@Override
	public int run(String[] args) throws Exception {
		System.out.println("Running AlphabetTest Program");

		if (args == null || args.length < 2) {
			System.err.println("Input and Output parameter is requirde");
			ToolRunner.printGenericCommandUsage(System.err);
			return -1;
		}

		Configuration conf = getConf();
		Job job = Job.getInstance(conf, "Alphabet Test");
		
		String inputPath = args[0];
		String outputPath = args[1];
		
		job.setJarByClass(getClass());
		job.setMapperClass(AlphabetTestMapper.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);

		//to accept the hdfs input and outpur dir at run time
		FileInputFormat.addInputPath(job, new Path(inputPath));
		FileOutputFormat.setOutputPath(job, new Path(outputPath));

		return job.waitForCompletion(true) ? 0 : 1;
	}
	
	public static void main(String args[]) throws Exception {
		int res = ToolRunner.run(new Configuration(), new AlphabetTest(), args);
		System.exit(res);
	}

}
