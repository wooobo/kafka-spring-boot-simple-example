package com.testkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class AutoCreateConfig {

    @Bean
    public NewTopic events() {
        return TopicBuilder.name("test-event-topic")
            .partitions(3)
            .replicas(3)
            .build();
    }
    @Bean
    public NewTopic testTopic01() {
        return TopicBuilder.name("test-topic-01")
                .partitions(3)
                .replicas(3)
                .build();
    }
}
