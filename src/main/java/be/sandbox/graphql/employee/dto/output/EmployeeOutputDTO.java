package be.sandbox.graphql.employee.dto.output;

import lombok.Builder;

@Builder
public record EmployeeOutputDTO(
        String id,
        String name,
        String lastName,
        int age,
        String department
) { }
