package be.sandbox.graphql.employee.service;

import be.sandbox.graphql.employee.dto.EmployeeDTO;
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

    public void createTestEmployee(EmployeeDTO employeeDTO) {
        employeeRepository.save(
                Employee.builder()
                        .name(employeeDTO.name())
                        .lastName(employeeDTO.lastName())
                        .age(employeeDTO.age())
                        .build()
        );
    }

    public List<EmployeeDTO> findEmployeesByName(String name) {
         return employeeRepository.findByName(name).stream()
                .map(EmployeeMapper::mapFrom)
                .collect(Collectors.toList());
    }
}
