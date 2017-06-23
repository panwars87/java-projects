package com.exp.learning.mapred;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author spanwar
 *
 */
public class AlphabetTestReducer 
	extends Reducer<IntWritable, IntWritable, IntWritable, IntWritable>{

	enum AlphabetTest{
		ERROR_LINES,
		LOG_LINES,
		REDUCER_ERROR,
		MAPPER_ERROR
	}
	
	public void reducer(IntWritable key, Iterable<IntWritable> values, Context context){
		try {
			int sum = 0;
			for(IntWritable value : values){
				sum += value.get();
			}
			context.write(key, new IntWritable(sum));
		} catch (IOException | InterruptedException e) {
			context.getCounter(AlphabetTest.REDUCER_ERROR).increment(1);
			e.printStackTrace();
		}
	}

}
