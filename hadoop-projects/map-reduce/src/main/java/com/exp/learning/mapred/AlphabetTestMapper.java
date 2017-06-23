package com.exp.learning.mapred;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author spanwar
 *
 */
public class AlphabetTestMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable> {

	enum AlphabetTest{
		ERROR_LINES,
		LOG_SUCCESS_LINES,
		REDUCER_ERROR,
		MAPPER_ERROR
	}

	private final static IntWritable one = new IntWritable(1);
	private IntWritable wCount = new IntWritable();
	private String word = new String();
	
	public void map(LongWritable key, Text value, Context context) {
		String line = value.toString();
		try{
			System.out.println("Line : "+ line);
			StringTokenizer st = new StringTokenizer(line);
			while(st.hasMoreElements()){
				word = st.nextToken();
				if(word.equalsIgnoreCase("nishu")){
					System.err.println("Corrupt record found : "+ line);
					context.getCounter(AlphabetTest.ERROR_LINES).increment(1);
				}else{
					context.getCounter(AlphabetTest.LOG_SUCCESS_LINES).increment(1);
					wCount.set(word.length());
					context.write(wCount, one);
				}
			}
		}catch(IOException | InterruptedException e){
			System.err.println("Error for record : "+ line);
			context.getCounter(AlphabetTest.MAPPER_ERROR).increment(1);
			e.printStackTrace();
		}
	}
}
