package be.sandbox.graphql.employee.dto.input;

import lombok.Builder;

@Builder
public record EmployeeInputDTO(
        String name,
        String lastName,
        Integer age,
        String department
) { }
