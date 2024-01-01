package com.example.demo.group;

import com.example.demo.rating.Rating;
import com.example.demo.teacher.Teacher;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class ClassTeacher {
    @Id
    @SequenceGenerator(name = "class_sequence", sequenceName = "class_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "class_sequence")
    private int id;
    private String name;
    private int max;
    @OneToMany
    private List<Teacher> teachers;
    @OneToMany
    private List<Rating> ratings;
    public ClassTeacher() {}
    public ClassTeacher(int id, String name, int max, List<Teacher> teachers, List<Rating> ratings)
    {
        this.id = id;
        this.name = name;
        this.max = max;
        this.teachers = teachers;
        this.ratings = ratings;
    }
    public ClassTeacher(String name, int max, List<Teacher> teachers, List<Rating> ratings)
    {
        this.name = name;
        this.max = max;
        this.teachers = teachers;
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "ClassTeacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", max=" + max +
                ", teachers=" + teachers +
                ", ratings=" + ratings +
                '}';
    }
}
