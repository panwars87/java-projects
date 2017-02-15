package in.edureka.mapreduce;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Partitioner;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class PartitionerCombiner_Hadoop1 {

	public static class Map extends MapReduceBase implements
			Mapper<LongWritable, Text, Text, IntWritable> {
	
		public void map(LongWritable key, Text value,
				OutputCollector<Text, IntWritable> output, Reporter reporter)
				throws IOException {

			String line = value.toString();
			StringTokenizer tokenizer = new StringTokenizer(line);

			while (tokenizer.hasMoreTokens()) {
				value.set(tokenizer.nextToken());
				output.collect(value, new IntWritable(1));
			}
		}
	}

	// Output types of Mapper should be same as arguments of Partitioner
	public static class MyPartitioner implements Partitioner<Text, IntWritable> {

		public int getPartition(Text key, IntWritable value, int numPartitions) {

			String myKey = key.toString().toLowerCase();

			if (myKey.equals("hadoop")) {
				return 0;
			}
			if (myKey.equals("data")) {
				return 1;
			} else {
				return 2;
			}
		}

		public void configure(JobConf arg0) {

			// Gives you a new instance of JobConf if you want to change Job
			// Configurations

		}
	}

	public static class Reduce extends MapReduceBase implements
			Reducer<Text, IntWritable, Text, IntWritable> {

		public void reduce(Text key, Iterator<IntWritable> values,
				OutputCollector<Text, IntWritable> output, Reporter reporter)
				throws IOException {

			int sum = 0;
			while (values.hasNext()) {
				sum += values.next().get();
				// sum = sum + 1;
			}

			// beer,3

			output.collect(key, new IntWritable(sum));
		}
	}

	public static void main(String[] args) throws Exception {

		JobConf conf = new JobConf(PartitionerCombiner_Hadoop1.class);
		conf.setJobName("wordcount");

		// Forcing program to run 3 reducers
		conf.setNumReduceTasks(3);

		conf.setMapperClass(Map.class);
		conf.setCombinerClass(Reduce.class);
		conf.setReducerClass(Reduce.class);
		conf.setPartitionerClass(MyPartitioner.class);

		conf.setOutputKeyClass(Text.class);
		conf.setOutputValueClass(IntWritable.class);

		conf.setInputFormat(TextInputFormat.class);
		conf.setOutputFormat(TextOutputFormat.class);

		 FileInputFormat.setInputPaths(conf, new Path(args[0]));
		 FileOutputFormat.setOutputPath(conf, new Path(args[1]));
		 
		JobClient.runJob(conf);
	}
}

