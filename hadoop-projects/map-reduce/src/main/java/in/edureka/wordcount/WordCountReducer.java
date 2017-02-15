package in.edureka.wordcount;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class WordCountReducer extends
		Reducer<Text, IntWritable, Text, IntWritable> {

	public WordCountReducer() {
		System.out.println("WordCount Reducer");
	}

	@Override
	protected void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int sum = 0;
		// TODO Auto-generated method stub
		for (IntWritable x : values)// --2
		{
			sum += x.get();
		}
		// sum =2
		context.write(key, new IntWritable(sum));
		// Hello,2
	}
}
