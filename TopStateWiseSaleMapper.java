package TopStateWise;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.hadoop.io.ByteWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*; 

public class TopStateWiseSaleMapper extends Mapper<Text, Text, CompanyState, IntWritable> {
	
    final static Pattern WORD_PATTERN = Pattern.compile("\\w+\\|\\w+\\|\\d+\\|\\w+\\|\\d+\\|\\d+");
    CompanyState outkey = new CompanyState();
	IntWritable outvalue = new IntWritable(1);
	public void map(Text key, Text value, Context context) 
			throws IOException, InterruptedException {
		
			
			Matcher matcher = WORD_PATTERN.matcher(key.toString());
            while (matcher.find()) {
                
                String company = matcher.group().toString().split("\\|")[0];
                String state = matcher.group().toString().split("\\|")[3];

                Text comptext = new Text();
                comptext.set(company);
                Text statetext = new Text();
                statetext.set(state);
                
                CompanyState outkey = new CompanyState(comptext, statetext);
             
                context.write(outkey, outvalue);
			
		}
		
	}
}

