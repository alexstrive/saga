package com.microservices.choreographyorchestrator.domain;

import com.microservices.choreographyorchestrator.domain.meta.CompensationInfo;
import com.microservices.choreographyorchestrator.domain.meta.ExecutionInfo;
import com.microservices.choreographyorchestrator.domain.meta.RetryInfo;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Getter
@Setter
public class SagaStepDefinition {
    @Id
    @GeneratedValue
    private Long id;
    private String sagaName;
    private String stepName;
    private ExecutionInfo successExecutionInfo;
    private ExecutionInfo failExecutionInfo;
    private CompensationInfo compensationInfo;
    private RetryInfo retryInfo;
}


