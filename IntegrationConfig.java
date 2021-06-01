package com.example.sample2app.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.messaging.MessageChannel;

import com.example.sample2app.model.Address;
import com.example.sample2app.model.Student;


@Configuration
@EnableIntegration
@IntegrationComponentScan
public class IntegrationConfig {
	@Bean
	public MessageChannel recieverChannel() {
		return new DirectChannel();
	}

	 @Bean
	 public MessageChannel replyChannel() {
	return new DirectChannel();
	}
	 @ServiceActivator(inputChannel = "router.channel")
		@Bean
		public PayloadTypeRouter payloadRouter() {
			PayloadTypeRouter router = new PayloadTypeRouter();
			router.setChannelMapping(Student.class.getName(), "student.channel");
			router.setChannelMapping(Address.class.getName(), "address.channel");
			return router;
		}
	
	
}