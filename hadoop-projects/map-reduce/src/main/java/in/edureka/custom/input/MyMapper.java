package in.edureka.custom.input;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
                       //MyKey -frist 3 values 
                      //Myvalue next two values
public class MyMapper extends Mapper<MyKey, MyValue, Text, Text> {
        
          protected void map(MyKey key, MyValue value, Context context)
              throws java.io.IOException, InterruptedException {
        	  
            String sensor = key.getSensorType().toString();
            
            if(sensor.toLowerCase().equals("a")){
            	context.write(value.getValue1(),value.getValue2());
            }
            		
          }  
}