/**
 * 
 */
package com.exp.learning.mapred;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/**
 * @author spanwar
 *
 */
public class WordCount extends Configured implements Tool{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public int run(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("Running WordCount Program");

		if (args == null || args.length < 2) {
			System.err.println("Input and Output parameter is requirde");
			System.exit(1);
		}

		Configuration conf = getConf();
		Job job = new Job(conf, "WordCount Example");

		String inputPath = args[0];
		String outputPath = args[1];
		
		job.setJarByClass(WordCount.class);
		job.setMapperClass(WordCountMapper.class);
		job.setReducerClass(WordCountReducer.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(IntWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		//to accept the hdfs input and outpur dir at run time
		FileInputFormat.addInputPath(job, new Path(inputPath));
		FileOutputFormat.setOutputPath(job, new Path(outputPath));

		return job.waitForCompletion(true) ? 0 : 1;
	}

	public static void main(String[] args) throws Exception {
		int res = ToolRunner.run(new Configuration(), new WordCount(), args);
		System.exit(res);
	}

}

class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
		String line = value.toString();
		System.out.println("Running Map on line : "+ line);
		StringTokenizer st = new StringTokenizer(line);

		while (st.hasMoreTokens())
		{
			word.set(st.nextToken());
			//sending to output collector which inturn passes the same to reducer
			System.out.println("Word is : "+ word.toString());
			context.write(word, one);
		}
	}

}

class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	
	//Reduce method for just outputting the key from mapper as the value from mapper is just an empty string   
	public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException
	{
		int sum = 0;
		/*iterates through all the values available with a key and add them together and give the
          final result as the key and sum of its values*/
		System.out.println("Reducer key is : "+ key.toString());
		System.out.println("Reducer values are : "+ values);
		for (IntWritable value : values)
		{
			sum += value.get();

		}
		context.write(key, new IntWritable(sum));
	}
}