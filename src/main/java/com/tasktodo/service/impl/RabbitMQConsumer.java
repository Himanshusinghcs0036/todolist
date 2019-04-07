package com.tasktodo.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.tasktodo.model.Employee;

@Component
public class RabbitMQConsumer {

	@RabbitListener(queues = "${rabbitmq.queue}")
	public void recievedMessage(Employee employee) {
		System.out.println("Recieved Message From RabbitMQ: " + employee);
	}
}
