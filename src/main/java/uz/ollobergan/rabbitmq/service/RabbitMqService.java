package uz.ollobergan.rabbitmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.ollobergan.rabbitmq.dto.RawMessageDto;

@Service
public class RabbitMqService {

    @Autowired
    RabbitTemplate rabbitTemplate;


    /**
     * Send message to RabbitMQ
     *
     * @param object
     * @param messageType
     */
    public void pushRawMessage(Object object, String messageType){
        RawMessageDto rawMessageDto = new RawMessageDto();
        rawMessageDto.setMessageType(messageType);
        rawMessageDto.setObject(object);
        rabbitTemplate.convertAndSend("demo_exchange","demo_routingkey",rawMessageDto);
    }

    /**
     * Send message own typical queue
     *
     * @param object
     */
    public void pushMessageToOwnQueue(RawMessageDto object, String routing_key){
        rabbitTemplate.convertAndSend("demo_exchange","demo_routingkey1",object.getObject());
    }
}
