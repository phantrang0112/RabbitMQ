package com.example.test_rabbitmq.service;

import com.example.test_rabbitmq.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${testrabbit.rabbitmq.exchange}")
    private String exchange;

    @Value("${testrabbit.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee company) {
        rabbitTemplate.convertAndSend(exchange, routingkey, company);
        System.out.println("Send msg = " + company);

    }
}
