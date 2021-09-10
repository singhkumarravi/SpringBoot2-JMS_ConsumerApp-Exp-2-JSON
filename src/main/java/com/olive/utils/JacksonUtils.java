package com.olive.utils;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.olive.model.Product;

@Component
public class JacksonUtils {
/**
 * This method take Product object as the @param prod and 
 *  Converted that object to Json Format and
 * @return json 
 */
	
	public String toJson(Product prod){
		String json=null;
		try {
			   json  = new ObjectMapper().writeValueAsString(prod);	
		} catch (Exception e) {
			json="Oject To Json Conversion Fail";
			e.printStackTrace();
		}    
		return json;
	}
	
	/*
	 * This method is used For Json To Object Conversion
	 */
	public Product toObject(String json) {
		Product prod =null;
		try {
			 prod = new ObjectMapper().readValue(json, Product.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prod;
	}
	
}
