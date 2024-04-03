package pl.pingwit.springdemo.controller.employee;

import org.springframework.web.bind.annotation.*;
import pl.pingwit.springdemo.service.employee.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable Integer id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public Integer createEmployee(@RequestBody CreateEmployeeInputDto inputDto) {
        return employeeService.createEmployee(inputDto);
    }

}
