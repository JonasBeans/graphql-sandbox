package be.sandbox.graphql.employee.entity;

import be.sandbox.graphql.employee.dto.input.EmployeeInputDTO;

public class EmployeeComparer {

    public static Employee compare(EmployeeInputDTO input, Employee existingEmployee) {
        if(isFieldDifferent(input.getAge(), existingEmployee.getAge()) ) {existingEmployee.setAge(input.getAge());}
        if(isFieldDifferent(input.getName(), existingEmployee.getName()) ) {existingEmployee.setName(input.getName());}
        if(isFieldDifferent(input.getLastName(), existingEmployee.getLastName()) ) {existingEmployee.setLastName(input.getLastName());}
        if(isFieldDifferent(input.getDepartment(), existingEmployee.getDepartment()) ) {existingEmployee.setDepartment(input.getDepartment());}
        return existingEmployee;
    }

    private static boolean isFieldDifferent(Object left, Object right) {
        if(left == null || right == null) return false;
        return !left.equals(right);
    }

    public static class EmployeeCompareException extends RuntimeException {

        private EmployeeCompareException(String message) {
            super(message);
        }

        public static EmployeeCompareException throwEmployeeNotFoundException() {
            return new EmployeeCompareException("Employee not found");
        }
    }
}
