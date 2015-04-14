package com.nick.learningspark;

import java.util.Arrays;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;


import scala.Tuple2;

public class WordCount8 {
	
	public static void main(String[] args){
		String sparkMaster = "spark://nick-prime:7077";
		String sparkHome = "/opt/spark/spark-1.3.0-bin-hadoop2.4/";
		String appName = "wordcount";
		//String[] jarLocation = new String[] { "E:\\workspace\\learningspark\\target\\learningspark-jar-with-dependencies.jar" };
		String[] jarLocation = new String[] { "/tmp/nickbd-jar-with-dependencies.jar" };

		String inputFile = "/tmp/README.md";
		String outputFile = "/tmp/wordcount";
		
		SparkConf conf = new SparkConf()
		.setMaster(sparkMaster)
		.setSparkHome(sparkHome)
		.setJars(jarLocation)
		.setExecutorEnv("spark.cores.max", "4")
		.set("spark.executor.memory", "4g")
		.set("spark.driver.host", "192.168.1.6")
		.setAppName("wordcount");

		JavaSparkContext sc = new JavaSparkContext(conf);
		JavaRDD<String> input = sc.textFile(inputFile);
		
		JavaRDD<String> words = input.flatMap( s -> Arrays.asList(s.split(" ")) );		
		
		JavaPairRDD<String,Integer> tuple = words.mapToPair( w -> new Tuple2<String,Integer>(w,1));
		
		JavaPairRDD<String,Integer> counts = tuple.reduceByKey((x,y) -> x+y);
		
		counts.saveAsTextFile(outputFile);
		
	}
	

}
