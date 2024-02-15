package com.andoliver46.ms.userservice.producers;

import com.andoliver46.ms.userservice.dtos.EmailRecordDTO;
import com.andoliver46.ms.userservice.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailProducer {

    @Value("${broker.queue.ms-mail.name}")//If exchange type is set to "" (default), then the routing key will be the same value as the name of the queue
    private String routingKey;

    //RabbitTemplate is used to send a message to a specific queue, needs connection to the instance and custom json conversion bean
    private final RabbitTemplate rabbitTemplate;

    public EmailProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishMailMessage(UserModel userModel){
        var emailDTO = new EmailRecordDTO(
                userModel.getId(),
                userModel.getEmail(),
                "Cadastro realizado com sucesso!",
                userModel.getName() + ", seja bem vindo(a)! \n\nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");

        rabbitTemplate.convertAndSend("", routingKey, emailDTO);

    }


}
