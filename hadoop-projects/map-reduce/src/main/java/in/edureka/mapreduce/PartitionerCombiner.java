package in.edureka.mapreduce;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class PartitionerCombiner extends Configured implements Tool {

	public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> {

		@Override
		public void map(LongWritable key, Text value,Context context)
				throws IOException, InterruptedException {

			String line = value.toString();
			StringTokenizer tokenizer = new StringTokenizer(line);

			while (tokenizer.hasMoreTokens()) {
				value.set(tokenizer.nextToken());
				context.write(value, new IntWritable(1));
			}
		}
	}

	// Output types of Mapper should be same as arguments of Partitioner
	public  static class MyPartitioner extends Partitioner<Text, IntWritable> {

		@Override
		public int getPartition(Text key, IntWritable value, int numPartitions) {

			String myKey = key.toString().toLowerCase();

			if (myKey.equals("hadoop")) {
				return 0;
			}
			if (myKey.equals("technology")) {
				return 1;
			} else {
				return 2;
			}
		}


	}


	public static class Reduce extends
			Reducer<Text, IntWritable, Text, IntWritable> {

		@Override
		public void reduce(Text key, Iterable<IntWritable> values,
				Context context)
				throws IOException, InterruptedException {
			Iterator<IntWritable> itr= values.iterator();
			int sum = 0;
			while (itr.hasNext()) {
				sum += itr.next().get();
				// sum = sum + 1;
			}

			// beer,3

			context.write(key, new IntWritable(sum));
		}
	}

	public static void main(String[] args) throws Exception {

		PartitionerCombiner wordcountDriver=new PartitionerCombiner();
		int res = ToolRunner.run(wordcountDriver, args);
		System.exit(res);
	}

	public int run(String[] args) throws Exception {
		Configuration conf= new Configuration();
	   //conf.set("fs.defaultFS", "file:///");
		//conf.setInt("mapreduce.task.partition",2);
		//conf.setJobName("mywc");
		Job job = Job.getInstance();
		job.setNumReduceTasks(3);
		job.setJarByClass(PartitionerCombiner.class);
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		job.setPartitionerClass(MyPartitioner.class);
		job.setCombinerClass(Reduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
	
		Path outputPath = new Path(args[1]);
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, outputPath);
	    //FileInputFormat.addInputPath(job, new Path("/home/edureka/Desktop/mapreduce"));
		//FileOutputFormat.setOutputPath(job, new Path("/home/edureka/Desktop/mapreduce_out_6"));
		outputPath.getFileSystem(conf).delete(outputPath,true);
		return job.waitForCompletion(true) ? 0 : 1;
	}
}

