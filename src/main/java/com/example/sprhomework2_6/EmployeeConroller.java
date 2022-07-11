package com.example.sprhomework2_6;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RequestMapping("/Employee")
@RestController
public class EmployeeConroller {

    private final EmployeeService employeeService;

    public EmployeeConroller(EmployeeService employeeService){
        this.employeeService=employeeService;
    }


    @GetMapping()
    public String meets(){
        return employeeService.meets();
    }

    @GetMapping("/findEmpl")
    public Employee findEmpl(@RequestParam(value = "firstName", required = false)String firstName,
                           @RequestParam(value = "secondName", required = false)String secondName) {
        return employeeService.findEmpl(firstName,secondName);
    }
    @GetMapping("/killEmpl")
    public String killEmpl(@RequestParam(value = "firstName", required = false)String firstName,
                           @RequestParam(value = "secondName", required = false)String secondName) {
        return employeeService.killEmpl(firstName,secondName);
    }
    @GetMapping("/addEmpl")
    public Employee addEmpl(@RequestParam(value = "firstName", required = false)String firstName,
                          @RequestParam(value = "secondName", required = false)String secondName,
                            @RequestParam(value = "salary", required = false)double salary,
                            @RequestParam(value = "depart", required = false)int depart) {
        return employeeService.addEmpl(firstName, secondName, salary, depart);
    }
    @GetMapping("/printMassive")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }


}
