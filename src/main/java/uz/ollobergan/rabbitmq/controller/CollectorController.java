package uz.ollobergan.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uz.ollobergan.rabbitmq.dto.ResponseDto;
import uz.ollobergan.rabbitmq.service.RabbitMqService;

@RestController
public class CollectorController {

    @Autowired
    RabbitMqService rabbitMqService;

    @PostMapping("/send/{message_type}")
    public ResponseDto sendMessage(@RequestBody Object object, @PathVariable("message_type") String messageType){
        rabbitMqService.pushRawMessage(object, messageType);
        return ResponseDto.success("Success",null);
    }
}
