package com.soumyadeep.bootKafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soumyadeep.bootKafka.producer.ProducerKafka;

@RestController
public class HomeController {

	@Autowired
	Environment env;

	@Autowired
	ProducerKafka producer;

	@RequestMapping(value = "/home")
	public String getResult(@RequestParam("input") String value) {

		try {
			producer.sendMessage(value);
		} catch (Exception e) {
			System.out.println("Inside Excotion");
		}

		return env.getProperty("message.response");
	}
}