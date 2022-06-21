package com.example.sprhomework2_6;
//
import com.example.sprhomework2_6.exeptions.EmployeeAlreadyAddedException;
import com.example.sprhomework2_6.exeptions.EmployeeNotFoundException;
import com.example.sprhomework2_6.exeptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service()
public class EmployeeService {
    private static final int LIMIT = 10;

    Map<String,Employee> emploees= new HashMap<>(1);

    //List<Employee> emploees = new ArrayList<>(10);

    //public Employee[] emploees = new Employee[10];

    public String meets() {
        return "priffki";
    }

    public Employee findEmpl(String firstName, String secondName){
        if(!emploees.containsKey(firstName+secondName)){
            throw new EmployeeNotFoundException("сотрудник не найден");
        }else{
            return emploees.get(firstName+secondName);
        }
    }

    public Employee addEmpl(String firstName, String secondName) {
        Employee emploee = new Employee(firstName, secondName);
        if (emploees.containsKey(firstName + secondName)) {
            throw new EmployeeAlreadyAddedException("Уже есть такой сотрудник");
        } else {
            emploees.put(firstName + secondName, emploee);
            return emploee;
        }
    }
/* 21_06_22
    public Employee findEmpl(String firstName, String secondName) {
        Employee emploee = new Employee(firstName, secondName);
            if (!emploees.contains(emploee)) {
                throw new EmployeeNotFoundException("сотрудник не найден");
            }
            return emploee;
        }

    public Employee addEmpl(String firstName, String secondName) {
        Employee emploee = new Employee(firstName, secondName);
        if (emploees.contains(emploee)) {
            throw new EmployeeAlreadyAddedException("Уже есть такой сотрудник");
        }
        if (emploees.size() < LIMIT) {
            emploees.add(emploee);
            return emploee;
        } else {
            throw new EmployeeStorageIsFullException("массив полон людей");
        }
    }


 */
/*
        int index = -1;
        for (int i = 0; i < emploees.size(); i++) {
            if (Objects.equals(emploees.get(i), emploee)) {
                throw new EmployeeAlreadyAddedException("Уже есть такой сотрудник");
            }
            if (Objects.isNull(emploees.get(i))) {//было if(emploees[i]==null)
                //emploees[i] = emploee;
                index = 1;
                break;
            }
        }
        if (index != -1) {
            emploees.add(index, emploee);
            //emploees.get(index) = emploee;
        } else {
            throw new EmployeeStorageIsFullException("массив полон людей");
        }
        return emploee;
*/
public String killEmpl(String firstName, String secondName) {
    if(!emploees.containsKey(firstName+secondName)){
        throw new EmployeeNotFoundException("сотрудник не найден");
    }else{
        emploees.remove(firstName+secondName);
        return firstName+" "+secondName+" WAS DELETED";//
    }
}
/* 21_06_22
    public Employee killEmpl(String firstName, String secondName) {
        Employee emploee = new Employee(firstName, secondName);
        if(!emploees.contains(emploee)){
            throw new EmployeeNotFoundException("сотрудник не найден");
        }
        for (int i = 0; i < emploees.size(); i++) {
            if (emploee.equals(emploees.get(i))) {
                emploees.remove(i);
                //emploees.get(i) = null;
            }
        }
        return emploee;
    }

 */

/* 21_06_22
    public List<Employee> printMassive() {
        for (int i = 0; i < emploees.size(); i++) {
            System.out.println(emploees.get(i));
        }
        return emploees;
    }

 */
}