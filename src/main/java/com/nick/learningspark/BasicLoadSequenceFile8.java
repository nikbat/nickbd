/**
 * Illustrates loading a sequence file of people and how many pandas they have seen
 */
package com.nick.learningspark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import scala.Tuple2;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;

import com.nickbd.data.RegistrationData;
import com.nickbd.data.RegistrationKey;

public class BasicLoadSequenceFile8 {
	

	public static void main(String[] args) throws Exception {
		
		String sparkMaster = "spark://nick-prime:7077";
		String sparkHome = "/opt/spark/spark-1.3.0-bin-hadoop2.4/";
		String appName = "wordcount";	
		String[] jarLocation = new String[] { "/tmp/nickbd-jar-with-dependencies.jar" };

		String inputFile = "/tmp/README.md";
		String outputFile = "/tmp/seqfile";
		String outputFile1 = "/tmp/seqfile1";
		
		SparkConf conf = new SparkConf()
		//.setMaster(sparkMaster)
		.setSparkHome(sparkHome)
		.setJars(jarLocation)
		.setExecutorEnv("spark.cores.max", "31")
		.set("spark.executor.memory", "4g")
		//.set("spark.driver.host", "192.168.1.6")
		.setAppName("BasicLoadSequenceFile8");

		String sequenceFilePath = "hdfs://192.168.1.6:9000/users/hadoop/registrations2/data";
		String sequenceFilePath1 = "hdfs://192.168.1.6:9000/users/hadoop/registrations3/data";
		
		JavaSparkContext sc = new JavaSparkContext(conf);
		//sc.addJar("/tmp/nickbd-jar-with-dependencies.jar");		
		JavaPairRDD<RegistrationKey, RegistrationData> input = sc.sequenceFile(sequenceFilePath,RegistrationKey.class, RegistrationData.class,8);
		
		JavaPairRDD<RegistrationKey, RegistrationData> input1 = sc.sequenceFile(sequenceFilePath1,RegistrationKey.class, RegistrationData.class,8);
		
		
		
		/*JavaPairRDD<String, String> result = input.mapToPair((Tuple2<RegistrationKey, RegistrationData> record) -> {
			System.out.println(record._1.getCookieId().toString()+" , "+ record._2.getZipCode().toString());
			return new Tuple2<String,String>(record._1.getCookieId().toString(), record._2.getZipCode().toString());
		});*/
		
		/*List<Tuple2<String, String>> resultList = result.collect();
		for (Tuple2<String, Integer> record : resultList) {
			System.out.println(record);
		}*/
		
		//result.saveAsTextFile(outputFile);
		
		JavaPairRDD<String, String> resultIterator = input.mapPartitionsToPair((Iterator<Tuple2<RegistrationKey, RegistrationData>> recordIterator) -> {
			boolean print = true;
			Tuple2<RegistrationKey, RegistrationData> data = null;
			ArrayList<Tuple2<String,String>> finalData = new ArrayList<Tuple2<String,String>>();
			while(recordIterator.hasNext()){
				data = recordIterator.next();
				if(print){
					System.out.println(data._1.getCookieId().toString()+ ","+data._2.getZipCode().toString());
					print = false;
				}
				finalData.add(new Tuple2<String,String>(data._1.getCookieId().toString(), data._2.getZipCode().toString()));
			}			
			return finalData;
		});
		
		JavaPairRDD<String, String> resultIterator1 = input1.mapPartitionsToPair((Iterator<Tuple2<RegistrationKey, RegistrationData>> recordIterator) -> {
			boolean print = true;
			Tuple2<RegistrationKey, RegistrationData> data = null;
			ArrayList<Tuple2<String,String>> finalData = new ArrayList<Tuple2<String,String>>();
			while(recordIterator.hasNext()){
				data = recordIterator.next();
				if(print){
					System.out.println(data._1.getCookieId().toString()+ ","+data._2.getZipCode().toString());
					print = false;
				}
				finalData.add(new Tuple2<String,String>(data._1.getCookieId().toString(), data._2.getZipCode().toString()));
			}			
			return finalData;
		});
		
		
			
		resultIterator.saveAsTextFile(outputFile);
		resultIterator1.saveAsTextFile(outputFile1);
		
	}
}
