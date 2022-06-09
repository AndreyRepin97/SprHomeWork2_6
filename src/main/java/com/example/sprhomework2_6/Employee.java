package com.example.sprhomework2_6;
//
import java.util.Objects;

public class Employee {
    private String firstName;
    private String secondName;


    public Employee (String firstName,String secondName)
    {
        this.firstName=firstName;
        this.secondName=secondName;

    }
    public String toString(){
        return  "||FIONEW|| "+firstName+" || "+secondName;
    }

    @Override
    public  boolean equals(Object o) {
        //return (a == b)||(a!=null&&a.equals(b));
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return secondName.equals(employee.secondName) && firstName.equals(employee.firstName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(secondName, firstName);
    }

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
}

