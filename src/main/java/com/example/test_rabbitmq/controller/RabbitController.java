package com.example.test_rabbitmq.controller;

import com.example.test_rabbitmq.model.Employee;
import com.example.test_rabbitmq.service.RabbitSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitController
{
    @Autowired
    RabbitSender rabbitMQSender;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId) {

        Employee emp=new Employee();
        emp.setId(empId);
        emp.setName(empName);
        System.out.println("shhsh"+empId);
        rabbitMQSender.send(emp);
        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }
}
