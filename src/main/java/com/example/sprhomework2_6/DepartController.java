package com.example.sprhomework2_6;

import static java.util.Arrays.stream;
import com.example.sprhomework2_6.DepartService;
import com.example.sprhomework2_6.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")


public class DepartController {

    private final DepartService departService;

    public DepartController(DepartService departService){
        this.departService=departService;
    }

    @GetMapping("/maxSalary")
    public Employee findEmplWithMaxSalFromDepart(@RequestParam("departId") int depart){
        return departService.findEmplWithMaxSalFromDepart(depart);
    }

    @GetMapping("/minSalary")
    public Employee findEmplWithMinSalFromDepart(@RequestParam("departId")int depart){
        return departService.findEmplWithMinSalFromDepart(depart);
    }

    @GetMapping(value = "/all",params = "departId")
    public List<Employee> findAllEmplFromDepart(@RequestParam("departId")int depart){
        return departService.findAllEmplFromDepart(depart);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findEmpl(){
        return departService.findEmpl();
    }

}
