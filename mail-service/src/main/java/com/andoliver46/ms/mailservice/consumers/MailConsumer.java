package com.andoliver46.ms.mailservice.consumers;

import com.andoliver46.ms.mailservice.dtos.EmailRecordDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MailConsumer {

    @RabbitListener(queues = "${broker.queue.ms-mail.name}")
    public void listenEmailQueue(@Payload EmailRecordDTO email){
        System.out.println(email.emailTo());
    }

}
