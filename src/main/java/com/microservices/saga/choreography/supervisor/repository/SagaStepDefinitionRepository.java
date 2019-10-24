package com.microservices.saga.choreography.supervisor.repository;

import com.microservices.saga.choreography.supervisor.domain.definition.SagaStepDefinition;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface SagaStepDefinitionRepository extends Neo4jRepository<SagaStepDefinition, Long> {
    SagaStepDefinition findSagaStepDefinitionBySagaNameAndStepName(String sagaName, String stepName);

    List<SagaStepDefinition> findSagaStepDefinitionsByStepName(String stepName);

    List<SagaStepDefinition> findSagaStepDefinitionsBySagaName(String sagaName);
}
