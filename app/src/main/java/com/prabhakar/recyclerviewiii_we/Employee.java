package com.prabhakar.recyclerviewiii_we;

public class Employee {
    private String name;
    private String salary;
    private String age;

    public Employee(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }

    public String getAge() {
        return age;
    }
}
