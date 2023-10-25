package uz.ollobergan.rabbitmq.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RawMessageDto<T> {

    private String messageType;
    private T object;

}
