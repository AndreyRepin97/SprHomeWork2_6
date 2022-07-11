package com.example.sprhomework2_6;
//
import com.example.sprhomework2_6.exeptions.EmployeeAlreadyAddedException;
import com.example.sprhomework2_6.exeptions.EmployeeNotFoundException;
import com.example.sprhomework2_6.exeptions.EmployeeStorageIsFullException;
import com.fasterxml.jackson.databind.ser.impl.MapEntrySerializer;
import org.springframework.stereotype.Service;
import static java.util.Arrays.stream;

import java.util.*;

@Service()
public class EmployeeService {
    private static final int LIMIT = 10;

    Map<String,Employee> emploees= new HashMap<>(1);

    private String getKey(String firstName, String secondName){
        return firstName+"|"+secondName;
    }

    public String meets() {
        return "priffki";
    }

    public Employee findEmpl(String firstName, String secondName){
        String key = getKey(firstName, secondName);
        if(!emploees.containsKey(key)){
            throw new EmployeeNotFoundException();//("сотрудник не найден")
        }
        return emploees.get(key);
    }


    public Employee addEmpl(String firstName,
                            String secondName,
                            double salary,
                            int depart) {
        Employee emploee = new Employee(firstName, secondName, salary, depart);
        String key = getKey(firstName, secondName);
        if (emploees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException("Уже есть такой сотрудник");
        }
        if (emploees.size() < LIMIT) {
            emploees.put(key, emploee);
            return emploee;
        }
        throw new EmployeeStorageIsFullException();
    }

public String killEmpl(String firstName, String secondName) {
    String key = getKey(firstName, secondName);
        if(!emploees.containsKey(firstName+secondName)){
        throw new EmployeeNotFoundException();//("сотрудник не найден")
    }
        Employee employee = emploees.get(key);
        emploees.remove(key);
        return employee+" WAS DELETED";
    }

    public List<Employee> getAll() {
        return new ArrayList<>(emploees.values());
    }
}
