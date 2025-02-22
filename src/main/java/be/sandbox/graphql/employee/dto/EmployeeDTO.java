package be.sandbox.graphql.employee.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public record EmployeeDTO(
        String name,
        String lastName,
        int age,
        String department
) { }
