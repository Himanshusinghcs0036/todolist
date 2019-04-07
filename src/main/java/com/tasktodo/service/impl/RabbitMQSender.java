package com.tasktodo.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.tasktodo.model.Employee;

@Service
public class RabbitMQSender {

	@Autowired
	private Environment env;

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("")
	private String exchange;

	@Value("")
	private String routingkey;

	public void send(Employee company) {
		rabbitTemplate.convertAndSend(env.getProperty("rabbitmq.exchange"), env.getProperty("rabbitmq.routingkey"),
				company);
		System.out.println("Send msg = " + company);

	}
}
