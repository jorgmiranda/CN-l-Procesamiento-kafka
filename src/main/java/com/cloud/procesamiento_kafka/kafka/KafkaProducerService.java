package com.cloud.procesamiento_kafka.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cloud.procesamiento_kafka.dto.AlertaDTO;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, AlertaDTO> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, AlertaDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarAlerta(AlertaDTO alertaDTO) {
        kafkaTemplate.send("alertas", alertaDTO);
        System.out.println("Enviado a Kafka: " + alertaDTO);
    }
}
