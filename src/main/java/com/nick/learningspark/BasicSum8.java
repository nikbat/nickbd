package com.nick.learningspark;
/**
 * Illustrates a simple fold in Java
 */


import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function2;

public class BasicSum8 {
	public static void main(String[] args) throws Exception {
		String master;
		if (args.length > 0) {
			master = args[0];
		} else {
			master = "local";
		}
		
		JavaSparkContext sc = new JavaSparkContext(master, "basicmap",
				System.getenv("SPARK_HOME"), System.getenv("JARS"));
		
		JavaRDD<Integer> rdd = sc.parallelize(Arrays.asList(1, 2, 3, 4));
		
		/*Integer result = rdd.fold(0,
				new Function2<Integer, Integer, Integer>() {
					public Integer call(Integer x, Integer y) {
						return x + y;
					}
				});*/
		
		Integer result = rdd.fold(0, (x,y) -> x+y);
		System.out.println(result);
	}
}
