/*package in.edureka.mapreduce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyDC {
	
	
	public static class MyMapper extends Mapper<LongWritable,Text, Text, Text> {
        
		
		private Map<String, String> abMap = new HashMap<String, String>();
				private Text outputKey = new Text();
				private Text outputValue = new Text();
		
		protected void setup(Context context) throws java.io.IOException, InterruptedException{
			//Path[] files = DistributedCache.getLocalCacheFiles(context.getConfiguration());
			URI[] filesUri = context.get
			
			for (URI uri : filesUri) {
				Path p=new Path(uri);
				if (p.getName().equals("state")) {
					BufferedReader reader = new BufferedReader(new FileReader(p.toString()));
					String line = reader.readLine();
					while(line != null) {
						String[] tokens = line.split("\t");
						String ab = tokens[0];
						String state = tokens[1];
						abMap.put(ab, state);
						line = reader.readLine();
					}
				}
			}
			if (abMap.isEmpty()) {
				throw new IOException("Unable to load Abbrevation data.");
			}
		}

		//ab ->[ka,karnataka] [tn,tanilbadu/
		//ab.get[column[0])
        protected void map(LongWritable key, Text value, Context context)
            throws java.io.IOException, InterruptedException {
        	//information from two files
        	//1 CH 
        	String row = value.toString();
        	String[] tokens = row.split("\t");
        	String inab = tokens[0];
        	String state = abMap.get(inab);
        	outputKey.set(state);
        	outputValue.set(row);
      	  	context.write(outputKey,outputValue);
        }  
}
	
	
  public static void main(String[] args) 
                  throws IOException, ClassNotFoundException, InterruptedException, URISyntaxException {
    
    Job job = Job.getInstance(new Configuration());
    job.setJarByClass(MyDC.class);
    job.setJobName("DCTest");
    job.setNumReduceTasks(0);
    job.addCacheFile(new URI("state"));
    //job.set..
    job.setMapperClass(MyMapper.class);
    job.setMapOutputKeyClass(Text.class);
    job.setMapOutputValueClass(Text.class);
    
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    
    job.waitForCompletion(true);
    
    
  }
}*/