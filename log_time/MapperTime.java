package log_time;

//Importing libraries
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MapperTime extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

	// Map function
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter rep)
			throws IOException {

		String line = value.toString();
		String[] fields = line.split(" ");
		if (fields.length == 10) {
			String val = fields[3];
			int pos = val.indexOf(':');			
			val = val.substring(pos+1,pos+3);
			output.collect(new Text(val), new IntWritable(1));
		}
	}
}
