package com.nickbd.mr;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import com.nickbd.data.RegistrationData;
import com.nickbd.data.RegistrationKey;

public class RandomMR extends Configured implements Tool {

	public static void main(final String[] args) throws Exception {
		int res = ToolRunner.run(new Configuration(), new RandomMR(),
				args);
		System.exit(res);
	}

	public int run(final String[] args) throws Exception {

		Path input = new Path("/users/hadoop/registrations/");
		Path output = new Path("/tmp/RandomMR/output/");

		Configuration conf = super.getConf();

		Job job = new Job(conf);
		job.setJarByClass(RandomMR.class);
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);

		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setInputFormatClass(org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);

		FileInputFormat.setInputPaths(job, input);
		FileOutputFormat.setOutputPath(job, output);

		if (job.waitForCompletion(true)) {
			System.out
					.println("Job completed successfully, use the following command to list the output:");
			System.out.println("");
			System.out.format("  hadoop fs -cat %s/part*%n", output.toString());

			return 0;
		}
		return 1;
	}

	/**
	 * The mapper, which emits each word and originating file as the output
	 * key/value pair.
	 */
	public static class Map extends Mapper<RegistrationKey, RegistrationData, Text, Text> {

		private Text documentId;
		private Text word = new Text();

		@Override
		protected void setup(Context context) {
			String filename = ((FileSplit) context.getInputSplit()).getPath()
					.getName();
			documentId = new Text(filename);
		}

		@Override
		protected void map(RegistrationKey key, RegistrationData value, Context context)
				throws IOException, InterruptedException {
			
			System.out.println("Nick "+key.getCookieId() + " ," + value.getZipCode());			
			context.write(key.getCookieId(), value.getZipCode());
			
		}
	}

	/**
	 * The reducer, which joins on all unique words in the input files, and
	 * emits all the files that contained the word.
	 */
	public static class Reduce extends Reducer<Text, Text, Text, Text> {

		

		@Override
		public void reduce(Text key, Iterable<Text> values, Context context)throws IOException, InterruptedException {

			for (Text docId : values) {
				System.out.println("Nick Reduce :"+key+","+docId);
				context.write(key , docId);
			}
			
		}
	}
}
