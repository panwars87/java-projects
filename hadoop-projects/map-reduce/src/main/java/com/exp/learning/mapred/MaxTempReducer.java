/**
 * 
 */
package com.exp.learning.mapred;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author spanwar
 *
 */
public class MaxTempReducer extends Reducer<Text, Text, Text, IntWritable>{
	
	private IntWritable tempVal = new IntWritable();
	
	public void reduce(Text key, Iterable<Text> values, Context context) 
			throws IOException, InterruptedException{
		int maxTemp = 0;
		System.out.println("Running for year : "+ key.toString());
		for(Text val : values){
			int x = Integer.parseInt(val.toString());
			if(maxTemp < x){
				maxTemp = x;
			}
			tempVal.set(maxTemp);
		}
		context.write(key, tempVal);
	}
	
}
