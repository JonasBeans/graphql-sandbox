package be.sandbox.graphql.employee.service;

import be.sandbox.graphql.employee.dto.input.EmployeeInputDTO;
import be.sandbox.graphql.employee.dto.output.EmployeeOutputDTO;
import be.sandbox.graphql.employee.entity.Employee;
import be.sandbox.graphql.employee.entity.EmployeeComparer;
import be.sandbox.graphql.employee.entity.EmployeeComparer.EmployeeCompareException;
import be.sandbox.graphql.employee.mapper.EmployeeMapper;
import be.sandbox.graphql.employee.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeOutputDTO createEmployee(EmployeeInputDTO input) {
        return EmployeeMapper.mapFrom(
                employeeRepository.save(
                        Employee.builder()
                                .id(UUID.randomUUID().toString())
                                .name(input.getName())
                                .lastName(input.getLastName())
                                .age(input.getAge())
                                .department(input.getDepartment())
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

    public EmployeeOutputDTO updateEmployee(EmployeeInputDTO input) {
        return Employee.update(
                input,
                employeeRepository.findById(input.getId())
                        .orElseThrow(EmployeeCompareException::throwEmployeeNotFoundException),
                EmployeeComparer::compare,
                employeeRepository::save,
                EmployeeMapper::mapFrom
        );
    }
}
