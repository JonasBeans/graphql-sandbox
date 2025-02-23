package be.sandbox.graphql.employee.service;

import be.sandbox.graphql.employee.dto.input.EmployeeInputDTO;
import be.sandbox.graphql.employee.dto.output.EmployeeOutputDTO;
import be.sandbox.graphql.employee.entity.Employee;
import be.sandbox.graphql.employee.mapper.EmployeeMapper;
import be.sandbox.graphql.employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeOutputDTO createEmployee(EmployeeInputDTO input) {
        return EmployeeMapper.mapFrom(
                employeeRepository.save(
                        Employee.builder()
                                .name(input.name())
                                .lastName(input.lastName())
                                .age(input.age())
                                .department(input.department())
                                .build()
                )
        );
    }

    public List<EmployeeOutputDTO> findEmployeesByName(String name) {
         return employeeRepository.findByName(name).stream()
                .map(EmployeeMapper::mapFrom)
                .collect(Collectors.toList());
    }

    public List<EmployeeOutputDTO> findAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(EmployeeMapper::mapFrom)
                .collect(Collectors.toList());
    }
}
