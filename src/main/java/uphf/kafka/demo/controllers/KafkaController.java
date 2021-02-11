package uphf.kafka.demo.controllers;

import uphf.kafka.demo.engine.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//declarer un controler REST API
//mappé sur localhost:9000/kafka

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {this.producer = producer;}

    /**********************************************************
    http://localhost:9000/kafka/publish?message=Hello the world
     * @param message
    ***********************************************************/
    
    //declare un service post pour le producer de nom publish.
    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        producer.sendMessage(message);
    }
}