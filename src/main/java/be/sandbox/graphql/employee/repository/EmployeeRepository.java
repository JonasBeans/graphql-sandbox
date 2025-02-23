package be.sandbox.graphql.employee.repository;

import be.sandbox.graphql.employee.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    List<Employee> findByName(String name);

}
