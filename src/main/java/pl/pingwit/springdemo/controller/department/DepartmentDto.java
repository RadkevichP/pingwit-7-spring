package pl.pingwit.springdemo.controller.department;

import pl.pingwit.springdemo.controller.employee.EmployeeDto;

import java.util.List;

public class DepartmentDto {

    private Integer id;
    private String name;

    private List<EmployeeDto> employees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }
}
