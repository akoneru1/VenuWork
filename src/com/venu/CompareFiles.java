package com.venu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CompareFiles {
	
	public static void main(String args[]){
		BufferedReader br = null;
		Set<String> paUpcs = new HashSet<String>();
		Set<String> phUpcs = new HashSet<String>();
		Set<String> totalUpcs = new HashSet<String>();
		Set<String> produceUpcs = new HashSet<String>();
		Set<String> deliUpcs = new HashSet<String>();
		Set<String> meatUpcs = new HashSet<String>();
		Set<String> floristUpcs = new HashSet<String>();
		List<String> totalUpcList = new ArrayList<String>();
		
		Map<String, Set<String>> filesToUpcs = new HashMap<String, Set<String>>();
		filesToUpcs.put("csl_product_attributes_NOAISLE_UPCS.sql", paUpcs);
		filesToUpcs.put("csl_product_hirarchy_NOAISLE_UPCS.sql", phUpcs);
		filesToUpcs.put("total_NOAISLE_UPCS.sql", totalUpcs);
		filesToUpcs.put("produceUpcs.sql", produceUpcs);
		filesToUpcs.put("deliUpcs.sql", deliUpcs);
		filesToUpcs.put("meatUpcs.sql", meatUpcs);
		filesToUpcs.put("floristUpcs.sql", floristUpcs);
		
		for(String fileName : filesToUpcs.keySet()){
			try {
				br = new BufferedReader(new FileReader(fileName));
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
				while(line != null){
					if(fileName.startsWith("total"))
						totalUpcList.add(line);
					filesToUpcs.get(fileName).add(line);
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
					}catch(Exception e){
						//TO DO
					}
				}
			}
		}
		System.out.println("Total unique no aisle upcs : " + totalUpcs.size());
		System.out.println("total number of upcs with no aisles : " + totalUpcList.size());
		System.out.println("no aisle upcs in pa : " + paUpcs.size());
		System.out.println("no aisle upcs in ph: " + phUpcs.size());
		System.out.println("produce upcs from pa : " + produceUpcs.size());
		System.out.println("deli upcs from pa : " + deliUpcs.size());
		System.out.println("meat upcs from pa : " + meatUpcs.size());
		System.out.println("florist upcs from pa : " + floristUpcs.size());
		int totalFound = 0;
		Set<String> upcNotInPh = new HashSet<String>();
		Set<String> upcNotInPa = new HashSet<String>();
		for(String upc : totalUpcs){
			if(phUpcs.contains(upc)){
				totalFound++;
			}else{
				upcNotInPh.add(upc);
			}
		}
		
		System.out.println(" UPC's not in PH " + upcNotInPh.size());
		int upcCount = 0;
		for(String upc : upcNotInPh){
			if(paUpcs.contains(upc)){
				upcCount++;
				upcNotInPa.add(upc);
			}
		}
		System.out.println("UPC not in Pa size " + upcNotInPa.size());
		
		System.out.println("Upc's founc in both ph and pa " + (upcCount + totalFound));
		
		//System.out.println("Printing UPCS :::::: " + upcNotInPa.toString());
		
		int numberOfupcsScannedWithNopaOrPhOrAisle = 0;
		
		for(String upc : produceUpcs){
			if(upcNotInPa.contains(upc)){
				numberOfupcsScannedWithNopaOrPhOrAisle++;
				upcNotInPa.remove(upc);
			}
		}
		
		System.out.println("left over upcs found in produce :: " + numberOfupcsScannedWithNopaOrPhOrAisle);
		
		int deliupcs = 0;
		
		for(String upc : deliUpcs){
			if(upcNotInPa.contains(upc)){
				deliupcs++;
				upcNotInPa.remove(upc);
			}
		}
		
		System.out.println("left over upcs found in deli :: " + deliupcs);

		int meatCount = 0;
		for(String upc : meatUpcs){
			if(upcNotInPa.contains(upc)){
				meatCount++;
				upcNotInPa.remove(upc);
			}
		}
		
		System.out.println("left over upcs found in meat section  :: " + meatCount);
		
		int floristCount = 0;
		for(String upc : floristUpcs){
			if(upcNotInPa.contains(upc)){
				floristCount++;
				upcNotInPa.remove(upc);
			}
		}
		
		System.out.println("left over upcs found in meat section  :: " + floristCount);
		
		int count = 0;
		for(String upc : totalUpcList){
			if(upcNotInPa.contains(upc))
				count++;
		}
		
		System.out.println("");
		System.out.println("");
		System.out.println("Printing out count " + count);
		System.out.println("Printing out upcs " + upcNotInPa.toString());
		
		paUpcs.clear();
		phUpcs.clear();
		totalUpcs.clear();
		//writeTOFile(variablesList);
	}
	
}
