package com.nickbd.util;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import org.apache.hadoop.yarn.webapp.hamlet.HamletSpec.MAP;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONTest {

	public static void main(String[] args) throws Exception {

		ObjectMapper objectMapper = new ObjectMapper();
		// Map<String,Object> userData = objectMapper.readValue(new
		// File("C:\\temp\\learning-spark-master\\files\\user.json"),
		// Map.class);
		JsonNode rootNode = objectMapper.readTree(new File(
				"C:\\temp\\user.json"));
		JsonNode nameNode = rootNode.path("name");
		String firstName = nameNode.get("first").textValue();
		System.out.println(firstName);
		System.out.println(rootNode.path("name").path("first").asText());
		System.out.println(rootNode.path("name").isArray());
		System.out.println(rootNode.path("name").isContainerNode());
		System.out.println("--------");
		

		rootNode = objectMapper.readTree(new File(
				"C:\\Installers\\MOCK_DATA.json"));
		System.out.println(rootNode.path("friend").isArray());
		System.out.println(rootNode.path("friend").isContainerNode());
		System.out.println(rootNode.isArray());
		System.out.println(rootNode.isContainerNode());
		
		Iterator<JsonNode> iterator = rootNode.elements();
		while(iterator.hasNext()){
			System.out.println(iterator.next().path("id").asText());
			break;
		}

	}

}
