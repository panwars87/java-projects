package pluralsight.samples;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by spanwar on 6/26/17.
 */

public class CensusReducer extends Reducer<Text, DoubleWritable, Text, DoubleWritable>{

    @Override
    public void reduce(Text key, Iterable<DoubleWritable> values, Context context)
            throws IOException, InterruptedException {

        context.getCounter("Reducer","COUNT_KEYS").increment(1);
        double sum = 0.0;
        int count = 0;

        for(DoubleWritable value : values) {
            context.getCounter("Reducer","COUNT_VALUES").increment(1);
            sum += value.get();
            count++;
        }

        double ratio = sum/count;
        context.write(key, new DoubleWritable(ratio));
    }
}
