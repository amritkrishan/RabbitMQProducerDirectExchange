package com.producer.rabbitmqproducer.service;

import com.producer.rabbitmqproducer.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${producer.rabbitmq.exchange}")
    private String exchange;

    @Value("${producer.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee emp) {
        rabbitTemplate.convertAndSend(exchange, routingkey, emp);
        System.out.println("Send msg = " + emp);

    }
}