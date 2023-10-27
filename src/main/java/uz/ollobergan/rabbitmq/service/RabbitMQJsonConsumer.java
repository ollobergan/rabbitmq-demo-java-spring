package uz.ollobergan.rabbitmq.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ollobergan.rabbitmq.dto.RawMessageDto;

@Service
public class RabbitMQJsonConsumer {


    @Autowired
    RabbitMqService rabbitMqService;

    @RabbitListener(queues = {"demo_queue"})
    public void consumeJsonMessage(RawMessageDto object){
        String message_type = object.getMessageType();
        switch (message_type){
            case "report":rabbitMqService.pushMessageToOwnQueue(object,"demo_routingkey1");
        }
    }
}
