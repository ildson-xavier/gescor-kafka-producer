package br.com.gescor.gescorkafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gescor.gescorkafka.engine.Producer;
import br.com.gescor.gescorkafka.service.GescorService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;
    
    @Autowired
    private GescorService service; 

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @GetMapping(value = "/load")
    public void sendMessageToKafkaTopic() {
        service.loadInsured();
    }
    
    @PostMapping(value = "/publishUser")
    public void sendObjectToKafkaTopic(@RequestBody String user) {
        this.producer.sendMessage(user);
    }
}
