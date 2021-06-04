package com.example.sample2app.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.sample2app.config.StudentConfig;
import com.example.sample2app.model.Address;
@Component
public class Consumer {
	 @RabbitListener(queues = StudentConfig.QUEUE)
	    public void consumeMessageFromQueue(Address address) {
	        System.out.println("Message recieved from queue : " + address);
	    }
}
