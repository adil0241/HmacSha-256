package com.simpleproject.maven.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSha256utils {
	//to make private there is no chance to create object of this 
	private HmacSha256utils() {
		
	}
	public static String generateSignature(String secretKey, String jsonInput) {
		String signature = null;
		 try {
	            // Your secret key as a byte array
	            
	            byte[] secretKeyBytes = secretKey.getBytes("UTF-8");

	            // Convert the JSON input to bytes
	            byte[] jsonInputBytes = jsonInput.getBytes("UTF-8");

	            // Create a SecretKeySpec object using the secret key and "HmacSHA256" algorithm
	            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, "HmacSHA256");

	            // Create an instance of the HMAC SHA-256 algorithm
	            Mac mac = Mac.getInstance("HmacSHA256");

	            // Initialize the MAC with the secret key
	            mac.init(secretKeySpec);

	            // Compute the HMAC
	            byte[] hmacBytes = mac.doFinal(jsonInputBytes);

	            // Encode the HMAC bytes to a base64 string for display or transmission
	            signature = Base64.getEncoder().encodeToString(hmacBytes);

	            System.out.println("JSON Input: " + jsonInput);
	            System.out.println("HMAC-SHA256: " + signature);
	        } 
		 
		 	catch (NoSuchAlgorithmException | InvalidKeyException | java.io.UnsupportedEncodingException e) {
	            e.printStackTrace();
	        }
		 return signature;
	    }

		
	}


