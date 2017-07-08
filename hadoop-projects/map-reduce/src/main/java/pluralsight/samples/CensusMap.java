package pluralsight.samples;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by spanwar on 6/26/17.
 */

public class CensusMap extends Mapper<LongWritable, Text, Text, DoubleWritable>{

    private Text tempKey = new Text();
    private DoubleWritable tempVal = new DoubleWritable();

    @Override
    public void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String line = value.toString();
        System.out.println("Line is: " + line);
        String[] valArr = line.split(",");

        tempKey.set(valArr[5]);
        tempVal.set(valArr[12] != null ? Double.parseDouble(valArr[12]) : 0);

        context.write(tempKey, tempVal);
    }
}
