package com.djs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.annotation.EnableJms;

import com.ibm.mq.spring.boot.MQConfigurationProperties;

@Configuration
@EnableJms
public class MQConfig {

	Logger logger = LoggerFactory.getLogger(MQConfig.class);
	
	@Value("${mq1.conn-name}")
	private String connectionName;
	
	@Value("${mq1.queue-manager}")
	private String queueManager;
	
	@Value("${mq1.channel}")
	private String channel;
	
	@Value("${mq1.username}")
	private String username;
	
	@Value("${mq1.password}")
	private String password;

	@Value("${mq1.mqname}")
	private String mqname;
	
	@Primary
	  @Bean
	  public MQConfigurationProperties mqConfigurationProperties() {
		MQConfigurationProperties props = new MQConfigurationProperties();
		
		logger.info("channel===>{}", channel);
		logger.info("password===>{}", password);
		logger.info("queueManager===>{}", queueManager);
		logger.info("connectionName===>{}", connectionName);
		logger.info("username===>{}", username);
		try {
			props.setConnName(connectionName);
			props.setChannel(channel);
			props.setUser(username);
			
			// if password is in encrypted form in property 
			// file then decryption can be done here
			props.setPassword(password);
			props.setQueueManager(queueManager);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return props;
	}


	

}