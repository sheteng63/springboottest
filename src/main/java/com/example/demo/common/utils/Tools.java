package com.example.demo.common.utils;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public  class Tools {
	public static String leftPad(String value,int len){
		String temp="";
		for(int i=value.length();i<len;i++){
			temp+="0";
		}
		return temp+value;
	}
	public static String rightPad(String value,int len){
		String temp="";
		for(int i=value.length();i<len;i++){
			temp+="0";
		}
		return value+temp;
	}
	public static String rightPad(String value,int len,String padStr){
		String temp="";
		for(int i=value.length();i<len;i++){
			temp+=padStr;
		}
		return value+temp;
	}
	public static String leftPad(String value,int len,String padStr){
		String temp="";
		for(int i=value.length();i<len;i++){
			temp+=padStr;
		}
		return temp+value;
	}
	
	public static HashMap<String, String> parserToMap(String s){  
	    Map map=new HashMap();  
	    JSONObject json;
		try {
			json = new JSONObject();
			Iterator keys=json.keys();  
		    while(keys.hasNext()){  
		        String key=(String) keys.next();  
		        String value=json.get(key).toString();  
		            map.put(key, value);  

		    }  
		} catch (JSONException e) {
			e.printStackTrace();
		}
	    
	    return (HashMap<String, String>)map;  
	}  
	
	
}
