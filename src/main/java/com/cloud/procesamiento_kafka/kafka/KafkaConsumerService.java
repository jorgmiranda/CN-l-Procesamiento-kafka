package com.cloud.procesamiento_kafka.kafka;

import java.util.List;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cloud.procesamiento_kafka.dto.AlertaDTO;
import com.cloud.procesamiento_kafka.dto.SignosVitalesKafkaDTO;
import com.cloud.procesamiento_kafka.rabbit.RabbitMQProducer;
import com.cloud.procesamiento_kafka.utils.EvaluadorSignosVitales;

@Service
public class KafkaConsumerService {
    private final KafkaProducerService kafkaProducerService;
    private final RabbitMQProducer rabbitMQProducer;

    public KafkaConsumerService(KafkaProducerService kafkaProducerService, RabbitMQProducer rabbitMQProducer) {
        this.kafkaProducerService = kafkaProducerService;
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @KafkaListener(topics = "senales_vitales", groupId = "grupo-consumidor-signos")
    public void consumirSignosVitales(SignosVitalesKafkaDTO signosVitales) {
        List<AlertaDTO> alertas = EvaluadorSignosVitales.evaluarCriticidad(signosVitales);

        if (alertas != null) {
            for (AlertaDTO alerta : alertas) {
                if ("crítico".equals(alerta.getSeveridad())) {
                    // Enviar alerta crítica a RabbitMQ
                    rabbitMQProducer.enviarAlerta(alerta);
                    // kafkaProducerService.enviarAlerta(alerta);
                } 
                else if ("moderado".equals(alerta.getSeveridad())) {
                    // Enviar alerta moderada al tópico `alertas`
                    kafkaProducerService.enviarAlerta(alerta);
                }
            }
        }
    }
}
