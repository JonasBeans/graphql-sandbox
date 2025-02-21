package be.sandbox.graphql.repository;

import be.sandbox.graphql.entity.TestEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestRepository extends MongoRepository<TestEntity, Long> { }
