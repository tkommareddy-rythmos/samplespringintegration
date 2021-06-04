package com.example.sample2app.config;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.amqp.support.converter.Jackson2XmlMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
	 public static final String QUEUE = "Student_queue";
	    public static final String EXCHANGE = "Student_exchange";
	    public static final String ROUTING_KEY = "Student_routingKey";

	    @Bean
	    public Queue queue() {
	        return new Queue(QUEUE);
	    }

	    @Bean
	    public TopicExchange exchange() {
	        return new TopicExchange(EXCHANGE);
	    }

	    @Bean
	    public Binding binding(Queue queue, TopicExchange exchange) {
	        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
	    }

	    @Bean
	    public MessageConverter converter() {
	        return new Jackson2XmlMessageConverter();
	    }

	    @Bean
	    public AmqpTemplate template(ConnectionFactory connectionFactory) {
	        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	        rabbitTemplate.setMessageConverter(converter());
	        return rabbitTemplate;
	    }
}
