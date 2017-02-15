package in.edureka.wordcount;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends
		Mapper<LongWritable, Text, Text, IntWritable> {

	public WordCountMapper() {
		System.out.println("WordCount Mapper");
	}

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		        //logic to generate output key and output value
				//write the output key and output value to the context
				//0,hadoop hadoop spark java
				String inputValue = value.toString();
				String values[]=inputValue.split(" ");
				for(String v:values){
					System.out.println("value is " + v);
					Text outputKey=new Text(v);
					IntWritable outputValue = new IntWritable(1);
					context.write(outputKey, outputValue);
					
				}
	}

}
