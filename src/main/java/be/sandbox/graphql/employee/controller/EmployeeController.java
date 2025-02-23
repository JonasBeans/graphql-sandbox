package be.sandbox.graphql.employee.controller;

import be.sandbox.graphql.employee.dto.input.EmployeeInputDTO;
import be.sandbox.graphql.employee.dto.output.EmployeeOutputDTO;
import be.sandbox.graphql.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @QueryMapping
    public List<EmployeeOutputDTO> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @QueryMapping
    public List<EmployeeOutputDTO> findEmployeeByName(@Argument String name) {
        return employeeService.findEmployeesByName(name);
    }

    @MutationMapping
    public EmployeeOutputDTO createEmployee(@Argument EmployeeInputDTO employee) {
        return employeeService.createEmployee(employee);
    }

    @MutationMapping
    public EmployeeOutputDTO updateEmployee(@Argument EmployeeInputDTO employee) {
        return employeeService.updateEmployee(employee);
    }

}
