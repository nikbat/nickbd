package com.nickbd.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class RemoteFileSystem {
	
	public static void main(String[] args) throws Exception{
		Configuration conf = new Configuration();
		//conf.set("mapred.job.tracker", "Hadoopmaster:54311"); 
		// like defined in hdfs-site.xml
		conf.set("fs.defaultFS", "hdfs://192.168.1.6:9000");
		
		FileSystem fs = FileSystem.get(conf);
		
		Path p = fs.getHomeDirectory();
		
		System.out.println(p);
		
	}

}
