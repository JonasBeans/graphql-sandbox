package be.sandbox.graphql.employee.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Document
public record Employee(
        String name,
        String lastName,
        int age,
        String department
) { }
