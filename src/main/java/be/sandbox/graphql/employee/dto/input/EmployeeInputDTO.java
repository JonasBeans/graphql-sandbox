package be.sandbox.graphql.employee.dto.input;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
@Builder
public class EmployeeInputDTO {
    String id;
    String name;
    String lastName;
    Integer age;
    String department;
}
