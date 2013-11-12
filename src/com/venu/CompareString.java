package com.venu;

import java.util.Random;

public class CompareString {

	public static void main(String[] args){
		String a = "13A";
		String b = "";
		
		int result = a.compareToIgnoreCase(b);
		if(result > 0){
			System.out.println(a + "  Result is : " + result);
		}else if(result < 0){
			System.out.println(b + "  Result is : " + result);
		}else
			System.out.println("Both the strings are equal. Result is : " + result);
		
		System.out.println("Next random Long value for n : 4000 is => " + nextLong(4000));
		
		
	}
	
	public static long nextLong(long n) {
		   // error checking and 2^x checking removed for simplicity.
		   long bits, val;
		   Random rng = new Random(System.currentTimeMillis());
		   do {
			   System.out.println("Next long : " + ((rng.nextLong() << 1) >>> 1));
		      bits = (rng.nextLong() << 1) >>> 1;
		      System.out.println("Bits value : " + bits);
		      val = bits % n;
		   } while (bits-val+(n-1) < 0L);
		   return val;
		}
}
