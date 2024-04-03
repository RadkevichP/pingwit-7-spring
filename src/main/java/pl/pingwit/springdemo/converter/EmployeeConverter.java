package pl.pingwit.springdemo.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.springdemo.controller.employee.CreateEmployeeInputDto;
import pl.pingwit.springdemo.controller.employee.EmployeeDto;
import pl.pingwit.springdemo.repository.department.Department;
import pl.pingwit.springdemo.repository.employee.Employee;

@Component
public class EmployeeConverter {

    public EmployeeDto toDto(Employee entity) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(entity.getId());
        employeeDto.setName(entity.getName());
        employeeDto.setSurname(entity.getSurname());
        employeeDto.setDepartment(entity.getDepartment().getName());
        return employeeDto;
    }

    public Employee toEntity(CreateEmployeeInputDto dto) {

        Department department = new Department();
        department.setId(dto.getDepartment());

        Employee entity = new Employee();
        entity.setDepartment(department);
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());

        return entity;
    }
}
