package pluralsight.samples;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by spanwar on 6/26/17.
 */
public class Census extends Configured implements Tool{

    @Override
    public int run(String[] args) throws Exception {

        if(args.length != 2){
            ToolRunner.printGenericCommandUsage(System.err);
            System.err.println("Input and Output parameter is required");
            return -1;
        }

        System.out.println("Running Census Job");

        Job job = Job.getInstance(getConf(), "Census Aggregate Job");
        job.setJarByClass(getClass());

        job.setMapperClass(CensusMap.class);
        job.setReducerClass(CensusReducer.class);

        //job.setMapOutputKeyClass(Text.class);
        //job.setMapOutputValueClass(DoubleWritable.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        return job.waitForCompletion(true) ? 0 : 1;
    }

    public static void main(String[] args) throws Exception{
        int res = ToolRunner.run(new Configuration(), new Census(), args);
        System.exit(res);
    }
}
