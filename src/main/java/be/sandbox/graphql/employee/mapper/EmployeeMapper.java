package be.sandbox.graphql.employee.mapper;

import be.sandbox.graphql.employee.dto.output.EmployeeOutputDTO;
import be.sandbox.graphql.employee.entity.Employee;

public class EmployeeMapper {

    public static EmployeeOutputDTO mapFrom(Employee employee) {
        return EmployeeOutputDTO.builder()
                .name(employee.name())
                .lastName(employee.lastName())
                .age(employee.age())
                .department(employee.department())
                .build();
    }
}
