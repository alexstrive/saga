package com.microservices.saga.choreography.supervisor.repository;

import com.microservices.saga.choreography.supervisor.domain.definition.SagaStepDefinition;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

public interface SagaStepDefinitionRepository extends Neo4jRepository<SagaStepDefinition, Long> {
    /**
     * Retrieves the node of the template graph by the name of the saga and the name of the event
     *
     * @param sagaName - the name of the saga
     * @param stepName - the name of the step
     * @return node of template graph
     */
    SagaStepDefinition findSagaStepDefinitionBySagaNameAndStepName(String sagaName, String stepName);

    /**
     * Retrieves all the nodes of the template graph of a specific saga
     *
     * @param sagaName - the name of the saga
     * @return all nodes of the saga
     */
    List<SagaStepDefinition> findSagaStepDefinitionsBySagaName(String sagaName);

    /**
     * Retrieves all the end nodes of the template graph of a specific saga
     *
     * @param sagaName - the name of the saga
     * @return all end nodes of the saga
     */
    @Query("MATCH (step:SagaStepDefinition{sagaName: {0}}) " +
            "WHERE NOT ()-[:PREVIOUS_STEP]->(step) " +
            "RETURN step")
    List<SagaStepDefinition> findEndNodesIdBySagasName(String sagaName);

    default List<SagaStepDefinition> findEndNodesBySagaName(String sagaName) {
        return findEndNodesIdBySagasName(sagaName).stream()
                .map(SagaStepDefinition::getId)
                .map(id -> findById(id).orElseThrow(IllegalArgumentException::new))
                .collect(toList());
    }
}
