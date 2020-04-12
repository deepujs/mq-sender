package com.djs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MQController {

	Logger logger = LoggerFactory.getLogger(MQController.class);
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${mq1.mqname}")
	private String mqname;
	
	@RequestMapping("/mq/send-message/{message}")
	public String sendMessage(@PathVariable String message) {
		logger.info(message);
		
		jmsTemplate.convertAndSend(mqname, message);
		logger.info("single message sending over");
		return " send to mq successfully";
	}
	
	
}
