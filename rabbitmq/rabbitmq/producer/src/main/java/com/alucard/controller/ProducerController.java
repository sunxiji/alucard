package com.alucard.controller;

import com.alucard.producer.FanoutProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
	@Autowired
	private FanoutProducer fanoutProducer;

	@RequestMapping("/sendFanout")
	public String sendFanout(String queueName) {
		fanoutProducer.send(queueName);
		return "success";
	}
}