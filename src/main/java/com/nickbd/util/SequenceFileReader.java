package com.nickbd.util;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.util.ReflectionUtils;

import com.nickbd.data.RegistrationData;
import com.nickbd.data.RegistrationKey;

public class SequenceFileReader {
	
	
	 public static void main(String[] args) throws Exception {
		 
		 
		  /*String uri = "/registrations/data";
		  Configuration conf = new Configuration();
		  FileSystem fs = FileSystem.get(URI.create(uri), conf);
		  
		  Path path = new Path(uri);
		  RegistrationKey key = new RegistrationKey();
		  RegistrationData value = new RegistrationData();
		  SequenceFile.Writer writer = null;
		  try {
		   
		   writer = SequenceFile.createWriter(fs, conf, path,RegistrationKey.class, RegistrationData.class);
		   
		   key.setCookieId("70121220900581087750091");key.setSessionId("7506283688149084695");value.setZipCode(new Text("10001"));writer.append(key, value);
		   key = new RegistrationKey();
		   key.setCookieId("70131214348860067800347");key.setSessionId("4200008213953857682");value.setZipCode(new Text("10002"));writer.append(key, value);
		   key = new RegistrationKey();
		   key.setCookieId("30151220891018088502503");key.setSessionId("6269300979524763355");value.setZipCode(new Text("10003"));writer.append(key, value);
		   key = new RegistrationKey();
		   key.setCookieId("50011208180449240824265");key.setSessionId("8693108325317207563");value.setZipCode(new Text("10004"));writer.append(key, value);
		   key = new RegistrationKey();
		   key.setCookieId("70061220884147252631395");key.setSessionId("436736509972635155");value.setZipCode(new Text("10005"));writer.append(key, value);
		   key = new RegistrationKey();
		   key.setCookieId("30071155836980000121185");key.setSessionId("6959543751669520466");value.setZipCode(new Text("10006"));writer.append(key, value);
		   key = new RegistrationKey();
		   key.setCookieId("70171218842498163635095");key.setSessionId("8033238568341738960");value.setZipCode(new Text("10007"));writer.append(key, value);
		   key = new RegistrationKey();
		   key.setCookieId("50071220778340322571872");key.setSessionId("5259212696848316708");value.setZipCode(new Text("10008"));writer.append(key, value);
		   key = new RegistrationKey();
		   key.setCookieId("50081220900687224568643");key.setSessionId("1718047510280515373");value.setZipCode(new Text("10009"));writer.append(key, value);
		   key = new RegistrationKey();
		   key.setCookieId("50121220889219122450022");key.setSessionId("7953908299403683308");value.setZipCode(new Text("10010"));writer.append(key, value);*/
		 
		 
		 
		 String sequenceFilePath = "hdfs://192.168.1.6:9000/users/hadoop/registrations/data";
		 Configuration conf = new Configuration();
		 org.apache.hadoop.io.SequenceFile.Reader.Option filePath = SequenceFile.Reader.file(new Path(sequenceFilePath));
		 
		 FileSystem fs = FileSystem.get(URI.create(sequenceFilePath), conf);
		 
	     //SequenceFile.Reader reader= new SequenceFile.Reader(fs,new Path(sequenceFilePath),conf);
	     SequenceFile.Reader reader = new SequenceFile.Reader(conf,filePath);
		 

	     RegistrationKey key = (RegistrationKey) ReflectionUtils.newInstance(reader.getKeyClass(), conf);
	     RegistrationData value = (RegistrationData) ReflectionUtils.newInstance(reader.getValueClass(), conf);
	     
	     while (reader.next(key, value)) {
	    	 System.out.println(key.getCookieId());
	    	 System.out.println(value.getZipCode());
	    	 
	    	 
	     }
	        
	        
		  	        
	     
		 
		  
	 }

}
