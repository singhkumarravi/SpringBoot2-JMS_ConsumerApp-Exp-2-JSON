package com.olive.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.olive.model.Product;
import com.olive.utils.JacksonUtils;

@Component
public class ConsumerService {
	
	@Autowired
	private  JacksonUtils util;
	
	@JmsListener(destination = "${my.jms.desti-name}")
	public void readData(String message) {
	 Product prod = util.toObject(message);
		             
		System.out.println("Data is Consumer Side :: " + prod);
	}

}
