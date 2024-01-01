package com.example.demo.teacher;

import jakarta.persistence.*;

@Entity
@Table
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")
    private int id;
    private String fName;
    private String lName;
    private double salary;
    private int year;
    private String cond;
    public Teacher() {}
    public Teacher(int id, String fName, String lName, double salary, int year, String cond)
    {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
        this.year = year;
        this.cond = cond;
    }
    public Teacher(String fName, String lName, double salary, int year, String cond) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
        this.year = year;
        this.cond = cond;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", salary=" + salary +
                ", year=" + year +
                ", cond='" + cond + '\'' +
                '}';
    }
}
