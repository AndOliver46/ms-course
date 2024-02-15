package com.andoliver46.ms.mailservice.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MailConsumer {

    @RabbitListener(queues = "${broker.queue.ms-mail.name}")
    public void listenEmailQueue(@Payload String string){
        System.out.println(string);
    }

}
