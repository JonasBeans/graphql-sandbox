package be.sandbox.graphql.employee.mapper;

import be.sandbox.graphql.employee.dto.EmployeeDTO;
import be.sandbox.graphql.employee.entity.Employee;

public class EmployeeMapper {

    public static EmployeeDTO mapFrom(Employee employee) {
        return EmployeeDTO.builder()
                .name(employee.name())
                .lastName(employee.lastName())
                .age(employee.age())
                .department(employee.department())
                .build();
    }
}
