package com.andoliver46.ms.mailservice.consumers;

import com.andoliver46.ms.mailservice.dtos.EmailRecordDTO;
import com.andoliver46.ms.mailservice.models.EmailModel;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MailConsumer {

    @RabbitListener(queues = "${broker.queue.ms-mail.name}")
    public void listenEmailQueue(@Payload EmailRecordDTO email){
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(email, emailModel);
        //send email
    }

}
