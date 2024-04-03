package pl.pingwit.springdemo.controller.department;

import org.springframework.web.bind.annotation.*;
import pl.pingwit.springdemo.service.department.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public DepartmentDto findDepartment(@PathVariable Integer id) {
        return departmentService.findDepartment(id);
    }

    @PostMapping
    public Integer createDepartment(@RequestBody CreateDepartmentInputDto inputDto) {
        return departmentService.createDepartment(inputDto);
    }

}
