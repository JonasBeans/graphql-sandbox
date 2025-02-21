package be.sandbox.graphql.service;

import be.sandbox.graphql.entity.TestEntity;
import be.sandbox.graphql.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TestService {

    private final TestRepository testRepository;

    public void createTestItem() {
        testRepository.save(
                TestEntity.builder()
                        .name("Jonas")
                        .lastname("Boon")
                        .age(24)
                        .build()
        );
    }
}
