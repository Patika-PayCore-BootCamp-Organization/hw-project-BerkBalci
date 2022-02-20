package com.example.Restaurant.Reservation.System.messaging.producer;

import com.example.Restaurant.Reservation.System.config.RabbitMQConfig;
import com.example.Restaurant.Reservation.System.model.Person;
import com.example.Restaurant.Reservation.System.model.PersonDTO;
import com.example.Restaurant.Reservation.System.service.PersonService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messaging/publish")
public class PersonProducer {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private PersonService personService;

    @PostMapping("/{message}")
    public String publishMessage(@PathVariable String message) {
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, message);
        return "Success";
    }

    @PostMapping("/passenger/{id}")
    public String publisherson(@PathVariable Integer id) {
        PersonDTO person = personService.getPerson(id);
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, person);
        return "Success";
    }
}
