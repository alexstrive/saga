package com.microservices.choreographyorchestrator.domain;

import com.microservices.choreographyorchestrator.domain.definition.SagaStepDefinition;
import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;

@Getter
@Setter
@RelationshipEntity(type = "EVENT")
public class SagaStepTransitionEvent {
    @Id
    @GeneratedValue
    private Long eventId;

    private String eventName;

    @StartNode
    private SagaStepDefinition previousStep;

    @EndNode
    private SagaStepDefinition nextStep;

    private Long creationDate;
}
