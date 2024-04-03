package pl.pingwit.springdemo.converter;

import org.springframework.stereotype.Component;
import pl.pingwit.springdemo.controller.department.CreateDepartmentInputDto;
import pl.pingwit.springdemo.controller.department.DepartmentDto;
import pl.pingwit.springdemo.repository.department.Department;

@Component
public class DepartmentConverter {

    private final EmployeeConverter employeeConverter;

    public DepartmentConverter(EmployeeConverter employeeConverter) {
        this.employeeConverter = employeeConverter;
    }

    public DepartmentDto toDto(Department entity) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(entity.getId());
        departmentDto.setName(entity.getName());
        departmentDto.setEmployees(entity.getEmployees().stream()
                .map(employeeConverter::toDto)
                .toList());

        return departmentDto;
    }

    public Department toEntity(CreateDepartmentInputDto dto) {
        Department department = new Department();
        department.setName(dto.getName());
        return department;
    }
}
