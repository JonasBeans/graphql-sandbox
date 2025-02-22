package be.sandbox.graphql.employee.controller;

import be.sandbox.graphql.employee.dto.EmployeeDTO;
import be.sandbox.graphql.employee.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public void makeTestItem(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.createTestEmployee(employeeDTO);
    }

    @QueryMapping()
    public List<EmployeeDTO> employeeByName(@Argument String name) {
        return employeeService.findEmployeesByName(name);
    }

}
