package uz.ollobergan.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    @RabbitListener(queues = {"demo_queue"})
    public void consumeJsonMessage(Object object){
        System.out.println(object.toString());
    }
}
