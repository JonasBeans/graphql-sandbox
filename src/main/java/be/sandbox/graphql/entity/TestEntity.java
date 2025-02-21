package be.sandbox.graphql.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@Document
public class TestEntity {
    String name;
    String lastname;
    int age;
}
