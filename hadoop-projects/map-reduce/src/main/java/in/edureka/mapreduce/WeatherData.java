package in.edureka.mapreduce;

import in.edureka.wordcount.WordCount;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class WeatherData {

	public static class MaxTemperatureMapper extends
			Mapper<LongWritable, Text, Text, Text> {

		@Override
		public void map(LongWritable arg0, Text Value,Context context)
				throws IOException, InterruptedException {

			String line = Value.toString();

			  // Example of Input 
			  //         Date                      Max     Min 
			  // 25380 20130101  2.514 -135.69   58.43     8.3     1.1     4.7     4.9     5.6     0.01 C     1.0    -0.1     0.4    97.3    36.0    69.4 -99.000 -99.000 -99.000 -99.000 -99.000 -9999.0 -9999.0 -9999.0 -9999.0 -9999.0
			
			
			String date = line.substring(6, 14);

			float temp_Max = Float.parseFloat(line.substring(39, 45).trim());
			float temp_Min = Float.parseFloat(line.substring(47, 53).trim());

			if (temp_Max > 40.0) {
				// Hot day
				context.write(new Text("Hot Day " + date),
						new Text(String.valueOf(temp_Max)));
			}

			if (temp_Min < 10) {
				// Cold day
				context.write(new Text("Cold Day " + date),
						new Text(String.valueOf(temp_Min)));
			}
		}

	}

	public static class MaxTemperatureReducer extends 
			Reducer<Text, Text, Text, Text> {

		@Override
		public void reduce(Text key, Iterable<Text> values,Context context)
				throws IOException, InterruptedException {

			// Find Max temp yourself ?
			Iterator<Text> itr=values.iterator();
			String temperature = itr.next().toString();
			context.write(key, new Text(temperature));
		}

	}

	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		String[] otherArgs = new GenericOptionsParser(conf,args).getRemainingArgs();
		job.setReducerClass(MaxTemperatureReducer.class);
		job.setMapperClass(MaxTemperatureMapper.class);
		job.setJarByClass(WordCount.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
		FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
		System.exit(job.waitForCompletion(true) ? 0: 1);
	}
}
