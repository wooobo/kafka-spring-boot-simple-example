package com.testkafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingConsumerAwareMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class EventsConsumerManualOffset implements AcknowledgingConsumerAwareMessageListener<Integer, String> {

    @Override
    @KafkaListener(topics = {"test2-event-topic"})
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord, Acknowledgment acknowledgment, Consumer<?, ?> consumer) {
        log.info("ConsumerRecord : {} ", consumerRecord);
        acknowledgment.acknowledge();
    }
}
