package in.edureka.wordcount;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class WordCount {

	public WordCount() {
		System.out.println("Init WordCountTest");
	}

	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		//stand alone mode
		//conf.set("fs.defaultFS", "file:///");
		
		Job job = Job.getInstance(conf);
		job.setReducerClass(WordCountReducer.class);
		job.setMapperClass(WordCountMapper.class);
		job.setJarByClass(WordCount.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
	   //job.setNumReduceTasks(2);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		//FileInputFormat.addInputPath(job, new Path("/home/edureka/Desktop/word_input"));
		
		//job output path location
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		//FileOutputFormat.setOutputPath(job, new Path("/home/edureka/Desktop/word_output"));
		
		System.exit(job.waitForCompletion(true) ? 0: 1);
	}
}
