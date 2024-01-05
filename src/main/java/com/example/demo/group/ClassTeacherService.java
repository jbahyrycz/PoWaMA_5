package com.example.demo.group;

import com.example.demo.rating.Rating;
import com.example.demo.teacher.Teacher;
import com.opencsv.CSVWriter;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
@Service
public class ClassTeacherService {
    private final ClassTeacherRepository classTeacherRepository;
    @Autowired
    public ClassTeacherService(ClassTeacherRepository classTeacherRepository)
    {
        this.classTeacherRepository = classTeacherRepository;
    }
    public List<ClassTeacher> getClasses()
    {
        return classTeacherRepository.findAll();
    }
    public void addNewClass(ClassTeacher classTeacher)
    {
        System.out.println(classTeacher);
        classTeacherRepository.save(classTeacher);
    }

    public void deleteClass(int classId)
    {
        if(!classTeacherRepository.existsById(classId))
        {
            return;
        }
        classTeacherRepository.deleteById(classId);
    }
    @Transactional
    public void updateClass(int classId, String name, int max, List<Teacher> teachers, List<Rating> ratings)
    {
        ClassTeacher classTeacher = classTeacherRepository.findById(classId).orElseThrow(() ->new IllegalStateException("no group"));
        classTeacher.setName(name);
        classTeacher.setMax(max);
        classTeacher.setTeachers(teachers);
        classTeacher.setRatings(ratings);
    }
    public List<Teacher> getTeachers(int classId)
    {
        ClassTeacher classTeacher = classTeacherRepository.findById(classId).orElseThrow(() ->new IllegalStateException("no class"));
        return classTeacher.getTeachers();
    }
    public String getFill(int classId)
    {
        ClassTeacher classTeacher = classTeacherRepository.findById(classId).orElseThrow(() ->new IllegalStateException("no class"));
        int cnt = 0;
        for (Teacher t: classTeacher.getTeachers())
        {
            cnt++;
        }
        double outputD = ((double)cnt/(double)classTeacher.getMax())*100.0;
        String outputS = Double.toString(outputD) + '%';
        return outputS;
    }
    public void addTeacher(int classId, Teacher teacher)
    {
        ClassTeacher classTeacher = classTeacherRepository.findById(classId).orElseThrow(() ->new IllegalStateException("no class"));
        List<Teacher> teachers = classTeacher.getTeachers();
        teachers.add(teacher);
        classTeacher.setTeachers(teachers);
    }
    public void addRating(int classId, Rating rating)
    {
        ClassTeacher classTeacher = classTeacherRepository.findById(classId).orElseThrow(() ->new IllegalStateException("no class"));
        List<Rating> ratings = classTeacher.getRatings();
        ratings.add(rating);
        classTeacher.setRatings(ratings);
    }
}
