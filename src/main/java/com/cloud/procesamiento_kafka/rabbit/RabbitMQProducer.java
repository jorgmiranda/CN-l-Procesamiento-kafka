package com.cloud.procesamiento_kafka.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.procesamiento_kafka.dto.AlertaDTO;
@Service
public class RabbitMQProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarAlerta(AlertaDTO alerta) {
        try {
            rabbitTemplate.convertAndSend(alerta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
