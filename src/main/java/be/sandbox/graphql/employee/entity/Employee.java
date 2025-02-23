package be.sandbox.graphql.employee.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Builder
@Document
public class Employee {

    private String id;
    private String name;
    private String lastName;
    private int age;
    private String department;

}
