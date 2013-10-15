package com.venu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringGetTest {

	public static void main(String args[]){
		String test = "17:18:19:20:21:2";
		String[] testList = test.split(":");
		Set<String> testSet = new HashSet<String>();
 		testSet.addAll(Arrays.asList(testList));
 		
 		String appName = "modopcoiphonessapp";
 		String[] appNameList = appName.split("_");
 		String pathInfo = "/customer/2210590929003/opco/SI/media";
 		System.out.println(pathInfo.substring(pathInfo.indexOf("opco")));
		//System.out.println(appNameList[1]);
	}
}
