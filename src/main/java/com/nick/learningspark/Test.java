package com.nick.learningspark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class Test {

	public static void main(String[] args) {
		
		
		String sparkMaster = "spark://16.108.159.90:7077";
		String sparkHome = "/opt/spark/spark-1.2.0-bin-hadoop2.4/";
		String appName = "wordcount";
		//String[] jarLocation = new String[] { "E:\\workspace\\learningspark\\target\\learningspark-jar-with-dependencies.jar" };
		String[] jarLocation = new String[] { "/tmp/learningspark-jar-with-dependencies.jar" };

		String inputFile = "/opt/spark/spark-1.2.0-bin-hadoop2.4/README.md";
		String outputFile = "/tmp/wordcount";
		
		SparkConf conf = new SparkConf()
		.setMaster(sparkMaster)
		.setSparkHome(sparkHome)
		.setJars(jarLocation)
		.setExecutorEnv("spark.cores.max", "4")
		.set("spark.executor.memory", "4g")
		.set("spark.driver.host", "16.108.159.90")
		.setAppName("wordcount");
		
		
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		


	}

}
