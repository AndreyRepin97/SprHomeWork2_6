package com.example.sprhomework2_6;
//
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.TreeSet;

public class Employee implements Comparable<Employee>{
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("secondName")
    private String secondName;
    private final double salary;
    private final int depart;


    public Employee(String firstName, String secondName, double salary, int depart) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
        this.depart = depart;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return depart == employee.depart &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(secondName, employee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secondName, firstName, salary, depart);
    }

    @Override
    public String toString(){
        return String.format("otdel "+depart+
                " firstName "+firstName+
                " secondName "+secondName+
                " salary "+salary );
    }

    public double getSalary() {
        return salary;
    }
    @Override
    public int compareTo(Employee o){
        return (int)(getSalary()- o.getSalary());
    }


    public int getDepart() {
        return depart;
    }

   // public String name() {
   //     TreeSet<Employee> treeSet = new TreeSet<>();
   //     treeSet.add(new Employee("","",1,1));
   //     return firstName+secondName;
   // }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

   // public void setSalary(double salary) {
   //    this.salary = salary;
   // }

   // public void setDepart(int depart) {
   //     this.depart = depart;
   // }
}
