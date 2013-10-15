package com.venu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorkTest {
	
	public static void main(String args[]){
		BufferedReader br = null;
		List<String> variablesList = new ArrayList<String>();
		
		try {
			br = new BufferedReader(new FileReader("SSSpecific.sql"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while(line != null){
				variablesList.add(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br != null){
				try{
					br.close();
					System.out.println(variablesList.toString());
				}catch(Exception e){
					//TO DO
				}
			}
		}
		String[] retailerList = args[0].split(",");
		writeToSqlFile(variablesList, retailerList);
		//writeTOFile(variablesList);
	}
	
	private static void writeToSqlFile(List<String> variablesList, String[] retailerList){
		String baseText = "";
		StringBuilder sb = new StringBuilder();
		for(String retailer : retailerList){
			for(String line : variablesList){
				String[] splitLine = line.split(",");
				String category = "'"+splitLine[0]+"',";
				String key = "'"+splitLine[1]+"',";
				String value = "'"+splitLine[2]+"',";
				
					baseText = "INSERT INTO MTS_APP_SETTINGS VALUES("+category+key+value+"'"+retailer+"');";
					sb.append(baseText);
					sb.append(System.getProperty("line.separator"));
				
			}
			sb.append(System.getProperty("line.separator"));
		}
		
		
		
		File testFile = new File("mts_app_settings.sql");
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(testFile));
			output.write(sb.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(output != null){
				try {
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	private static void writeTOFile(List<String> variablesList){
		String baseText = "";
		StringBuilder sb = new StringBuilder();
		for(String line : variablesList){
			String[] splitLine = line.split(":");
			String[] sourceList = splitLine[0].split(",");
			String[] destList = splitLine[1].split(",");
			String[] portList = splitLine[2].split(",");
			for(String source : sourceList){
				for(String dest : destList){
					for(String port : portList){
						baseText = "acces-list inside extended permit tcp host "+source+" host "+dest+" eq "+port;
						sb.append(baseText);
						sb.append(System.getProperty("line.separator"));
					}
					sb.append(System.getProperty("line.separator"));
				}
				sb.append(System.getProperty("line.separator"));
			}
			
		}
		
		File testFile = new File("test.txt");
		BufferedWriter output = null;
		try {
			output = new BufferedWriter(new FileWriter(testFile));
			output.write(sb.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(output != null){
				try {
					output.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
