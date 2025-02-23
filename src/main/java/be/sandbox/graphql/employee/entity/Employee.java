package be.sandbox.graphql.employee.entity;

import be.sandbox.graphql.employee.dto.input.EmployeeInputDTO;
import be.sandbox.graphql.employee.dto.output.EmployeeOutputDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

@Setter
@Getter
@Builder
@Document
public class Employee {

    private String id;
    private String name;
    private String lastName;
    private int age;
    private String department;

    public static EmployeeOutputDTO update(
            EmployeeInputDTO input,
            Employee entity,
            BiFunction<EmployeeInputDTO, Employee, Employee> compare,
            UnaryOperator<Employee> save,
            Function<Employee, EmployeeOutputDTO> map
    ) { return compare.andThen(save).andThen(map).apply(input, entity); }

}
