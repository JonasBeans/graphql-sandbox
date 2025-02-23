package be.sandbox.graphql.employee.mapper;

import be.sandbox.graphql.employee.dto.output.EmployeeOutputDTO;
import be.sandbox.graphql.employee.entity.Employee;

public class EmployeeMapper {

    public static EmployeeOutputDTO mapFrom(Employee employee) {
        return EmployeeOutputDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .lastName(employee.getLastName())
                .age(employee.getAge())
                .department(employee.getDepartment())
                .build();
    }
}
