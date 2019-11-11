package com.microservices.saga.choreography.supervisor.repository;

import com.microservices.saga.choreography.supervisor.domain.SagaStepInstance;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

/**
 * CRUD for the saga instances
 */
public interface SagaStepInstanceRepository extends Neo4jRepository<SagaStepInstance, Long> {
    /**
     * Returns the node of the saga instance graph by the saga instance id and the name of the step
     *
     * @param sagaInstanceId - the id of the saga instance
     * @param stepName       - the name of the step
     * @return node of the saga instance graph
     */
    SagaStepInstance findSagaStepInstanceBySagaInstanceIdAndStepName(Long sagaInstanceId, String stepName);

    /**
     * Returns the node of the saga instance graph by the saga instance id and the id of the node in the template graph
     *
     * @param sagaInstanceId       - the id of the saga instance
     * @param sagaStepDefinitionId - the id of the saga step definition
     * @return node of the saga instance graph
     */
    SagaStepInstance findSagaStepInstanceBySagaInstanceIdAndSagaStepDefinitionId(Long sagaInstanceId, Long sagaStepDefinitionId);

    /**
     * Returns all the nodes of saga instance graph by saga name and saga instance id
     *
     * @param sagaInstanceId - the id of the saga instance
     * @return all nodes of the saga step instance graph
     */
    List<SagaStepInstance> findSagaStepInstancesBySagaInstanceId(Long sagaInstanceId);
}
