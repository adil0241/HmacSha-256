package com.simpleproject.maven.service;

import com.google.gson.Gson;
import com.simpleproject.maven.JSON.AddRequest;
import com.simpleproject.maven.util.HmacSha256utils;

public class TestService {
	//business logic and you need to generate sign. i.e is utility so create and another class and generate their
	
	public String secretKey="CT";
	public  int ValidateAndProcess(AddRequest req, String ClientSignature) {
		
		Gson gson=new Gson();
		String jsonRequest=gson.toJson(req);
		System.out.println("inputString: "+jsonRequest);
		
		String generatedSig=HmacSha256utils.generateSignature(secretKey,jsonRequest);
		System.out.println("generatedSig: "+generatedSig);
		if(generatedSig.equals(ClientSignature)) {
			return req.getNum1()+req.getNum2();		}
	
		return -1;
	}

}
