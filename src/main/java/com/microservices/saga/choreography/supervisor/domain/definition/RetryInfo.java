package com.microservices.saga.choreography.supervisor.domain.definition;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RetryInfo {
    private int timeout;

    private String timeUnit;

    private int attempts;

    private KafkaRetry kafkaRetry;
}
