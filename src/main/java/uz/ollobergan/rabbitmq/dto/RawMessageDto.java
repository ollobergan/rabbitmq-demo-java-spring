package uz.ollobergan.rabbitmq.dto;


import lombok.Data;

@Data
public class RawMessageDto<T> {

    private String messageType;
    private T object;

}
