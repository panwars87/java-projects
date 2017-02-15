package in.edureka.project;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.*;

public class MarketEvaluation{

	public static class MapClass extends Mapper<LongWritable, Text, Text, Text> {

		private Text location = new Text();
		private Text rating = new Text();

		/*
		 * @Override public void map(LongWritable key, Text value,
		 * OutputCollector<Text, Text> output, Reporter reporter) throws
		 * IOException {
		 */

		@Override
		protected void map(LongWritable key, Text value, Context context)
				throws IOException, InterruptedException {
			String[] rows = value.toString().split(",");
			if (rows.length > 28) { // Each row has 29 columns
				String marketName = rows[0];
				String website = rows[1];
				String city = rows[2];
				String state = rows[3];

				int count = 0; // Initialized with Zero
				String evaluation = "Not Evaluated";

				for (int col = 4; col <= 28; col++) // columns 4-28 contain data
													// about what the market
													// offers in 'Y' or 'N'
													// format
				{
					if (rows[col].equals("Y"))
						count++;
				}

				count = (count * 100) / 25; // There are 25 segments of market
											// offerings, and it calculates %age
											// of 'Y'

				if (count > 59) { // Assigning 60-100% as High Value Market

					evaluation = "High";

				} else if (count > 39 && count < 60) { // Assigning 40-59% as
														// Medium Value Market

					evaluation = "Medium";

				} else if (count > 0 && count < 40) { // Assigning 1-39% as Low
														// Value Market

					evaluation = "Low";

				} else if (count == 0) {

					evaluation = "Zero";

				}

				location.set(marketName + ", " + website + ", " + city + ", "
						+ state + ", ");
				rating.set(evaluation + "\t" + count);
				context.write(location, rating);
			}
		}
	}

	public static class Reduce extends Reducer<Text, Text, Text, Text> {

		@Override
		protected void reduce(Text key, Iterable<Text> value, Context context)
				throws IOException, InterruptedException {
			int rating = 0; // Variable Initialized
			String strEvaluation = "Not Evaluated"; // Variable Initialized
			Iterator<Text> values = value.iterator();
			while (values.hasNext()) {
				String tokens[] = (values.next().toString()).split("\t");
				String strEval = String.valueOf(tokens[0]); // gets string Value
															// as High or Medium
															// or Low or Zero
				int val = Integer.parseInt(tokens[1]); // gets %age value

				if (val > 0) {
					rating = val;
					strEvaluation = strEval;
				}

			}

			context.write(key, new Text(strEvaluation + "," + rating + "%"));
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf,"MarketEvaluation");
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		job.setMapperClass(MapClass.class);
		job.setReducerClass(Reduce.class);

		job.setJarByClass(MarketEvaluation.class);
		
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		System.exit(job.waitForCompletion(true) ? 0: 1);
	}
}