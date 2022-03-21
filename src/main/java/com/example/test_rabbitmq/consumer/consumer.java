package com.example.test_rabbitmq.consumer;

import com.example.test_rabbitmq.model.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class consumer {
    @Value("${testrabbit.rabbitmq.queue}")
    String queueName;
    @RabbitListener(queues = "queue")
    public void consumer(Employee employee){
        System.out.println("message: "+employee.getId());
    }
}
