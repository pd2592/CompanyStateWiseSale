package TopStateWise;

import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.conf.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat; 
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

public class TopStateWiseSale {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		
		Job job = new Job(conf, "TelevisionSaleCompanyWise");
		job.setJarByClass(TopStateWiseSale.class);

		job.setMapOutputKeyClass(CompanyState.class);
		job.setMapOutputValueClass(IntWritable.class);

		job.setOutputKeyClass(CompanyState.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setMapperClass(TopStateWiseSaleMapper.class);
		job.setReducerClass(TopStateWiseSaleReducer.class);
		//job.setPartitionerClass(SoldPerComapnyPartitioner.class);
		
		job.setInputFormatClass(SequenceFileInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.addInputPath(job, new Path("hdfs://localhost:9000/user/acadgild/hadoop/outputtelevision1/part-r-00000")); 
		FileOutputFormat.setOutputPath(job,new Path("hdfs://localhost:9000/user/acadgild/hadoop/outputtelevision1/soldcompanystatewiseSeq"));
		
		/*
		Path out=new Path(args[1]);
		out.getFileSystem(conf).delete(out);
		*/
		
		job.waitForCompletion(true);
	}
}
