package com.microservices.choreographyorchestrator.repository;

import com.microservices.choreographyorchestrator.domain.SagaStepInstance;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface SagaStepInstanceRepository extends Neo4jRepository<SagaStepInstance, Long> {
    SagaStepInstance findSagaStepInstanceBySagaInstanceId(Long sagaInstanceId);

    List<SagaStepInstance> findSagaStepInstancesBySagaName(String sagaName);
}
