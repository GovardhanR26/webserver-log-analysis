package log_page;

//Importing libraries
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class ReducerPage extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {
//	static int keyCount = 0;
//	static Text maxPage = null;
//	static int maxVal = 0;

	// Reduce function
	public void reduce(Text key, Iterator<IntWritable> value, OutputCollector<Text, IntWritable> output, Reporter rep)
			throws IOException {

		int count = 0;

		// Counting the frequency of each words
		while (value.hasNext()) {
			IntWritable i = value.next();
			count += i.get();
		}
		
//		if(count>maxVal) {
//			maxVal = count;
//			maxPage = key;
//		}

//		keyCount++;
		
		output.collect(key, new IntWritable(count));

//		if (keyCount == 42376) {
//			output.collect(maxPage, new IntWritable(maxVal)); // correct code
//		}

//		output.collect(key, new IntWritable(keyCount)); // to count no. of keys
	}
}
