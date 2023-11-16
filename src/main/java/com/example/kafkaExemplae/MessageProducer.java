package com.example.kafkaExemplae;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String topic, DataResquetDTO dataResquetDTO) {
        kafkaTemplate.send(topic, dataResquetDTO);
    }

}
