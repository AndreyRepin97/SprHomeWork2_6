package com.example.sprhomework2_6;

import com.example.sprhomework2_6.exeptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class DepartService {
    private final EmployeeService employeeService;

    public DepartService(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    public Employee findEmplWithMaxSalFromDepart(int depart) {
        return employeeService.getAll().stream()
                .filter(emploee -> emploee.getDepart() == depart)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee findEmplWithMinSalFromDepart(int depart) {
        return employeeService.getAll().stream()
                .filter(emploee -> emploee.getDepart() == depart)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> findAllEmplFromDepart(int depart) {
        return employeeService.getAll().stream()
                .filter(emploee -> emploee.getDepart() == depart)
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Employee>> findEmpl() {
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepart));
    }
}
