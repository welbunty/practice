package com.reyaz.testcase;

import org.apache.commons.codec.binary.Base64;

public class EndodingAndDecoding 
{
 public static void main(String[] args)
 {
	 String str="reyaz1123";
	//String to bytes values
	 byte[] encodedString = Base64.encodeBase64(str.getBytes());
	 System.out.println("Encoded String is-->"+ new String(encodedString));
	 System.out.println("================================================");
 byte[]	decodedString= Base64.decodeBase64(encodedString);
 System.out.println("Decoded String ia--->"+new String(decodedString));
	
 }
}
