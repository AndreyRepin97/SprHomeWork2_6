package com.example.sprhomework2_6;
//
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@ResponseStatus
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
                          @RequestParam(value = "secondName", required = false)String secondName) {
        return employeeService.addEmpl(firstName,secondName);
    }



    @GetMapping("/printMassive")
    public Map<String, Employee> printMassive() {//Employee[]
        //System.out.println(employeeService.emploees);
        return employeeService.emploees;
    }


/*
    @GetMapping("/firstName")
    public String enteringFirstName(@RequestParam(value = "firstName", required = false)String firstName){
        return firstName;
    }
    @GetMapping("/secondName")
    public String enteringSecondName(@RequestParam(value = "secondName", required = false)String secondName){
        return secondName;
    }
*/

}
