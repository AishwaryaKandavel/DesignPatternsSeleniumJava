package com.designpatternseleniumjava.abstractcomponent;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataLoader {
	public static List<List<HashMap<String, String>>> getJsonData(String fileName) {
		List<List<HashMap<String, String>>> val = new ArrayList<List<HashMap<String,String>>>();
		try {
			String currentDir = System.getProperty("user.dir")+"\\src\\main\\resources\\";
			String value = FileUtils.readFileToString(new File(currentDir+fileName+".json"), StandardCharsets.UTF_8);
			ObjectMapper objmap = new ObjectMapper();
			val = objmap.readValue(value, new TypeReference<List<List<HashMap<String, String>>>>(){});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}
	public static void main(String args[]) {
		getJsonData("OneWay"); 
		getJsonData("RoundTrip"); 
		getJsonData("MultiTrip"); 
	}
}
