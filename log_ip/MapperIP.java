package log_ip;

//Importing libraries
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class MapperIP extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

	// Map function
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter rep)
			throws IOException {
		String line = value.toString();
		String[] fields = line.split(" ");
		if (fields.length == 10) {
			output.collect(new Text(fields[0]), new IntWritable(1));
		}
	}
}
