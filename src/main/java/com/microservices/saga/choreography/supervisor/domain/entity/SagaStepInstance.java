package com.microservices.saga.choreography.supervisor.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class SagaStepInstance {
    @Id
    @GeneratedValue
    private Long id;

    private Long sagaInstanceId;

    private String sagaName;

    private String stepName;

    private Long sagaStepDefinitionId;

    private String stepStatus;

    private Long startTime;

    private Long endTime;
}
