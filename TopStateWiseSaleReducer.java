package TopStateWise;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class TopStateWiseSaleReducer extends Reducer<CompanyState, IntWritable, CompanyState, IntWritable>
{	
	IntWritable outValue = new IntWritable();
	
	public void reduce(CompanyState key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException
	{
		int counter = 0;
		int sum = 0;
		for (IntWritable value : values) {
				sum += value.get();
			}
		
		}
	
	}
