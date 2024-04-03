package pl.pingwit.springdemo.service.department;

import org.springframework.stereotype.Service;
import pl.pingwit.springdemo.controller.department.CreateDepartmentInputDto;
import pl.pingwit.springdemo.controller.department.DepartmentDto;
import pl.pingwit.springdemo.converter.DepartmentConverter;
import pl.pingwit.springdemo.exception.PingwitNotFoundException;
import pl.pingwit.springdemo.repository.department.Department;
import pl.pingwit.springdemo.repository.department.DepartmentRepository;

@Service
public class DepartmentService {

    private final DepartmentConverter departmentConverter;
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentConverter departmentConverter, DepartmentRepository departmentRepository) {
        this.departmentConverter = departmentConverter;
        this.departmentRepository = departmentRepository;
    }

    public DepartmentDto findDepartment(Integer id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new PingwitNotFoundException("Department not found!"));
        return departmentConverter.toDto(department);
    }


    public Integer createDepartment(CreateDepartmentInputDto inputDto) {
        Department entity = departmentConverter.toEntity(inputDto);
        return departmentRepository.save(entity).getId();
    }
}
