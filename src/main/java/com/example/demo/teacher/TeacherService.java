package com.example.demo.teacher;

import jakarta.transaction.Transactional;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.io.FileWriter;
@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    public List<Teacher> getTeachers()
    {
        return teacherRepository.findAll();
    }
    public void addNewTeacher(Teacher teacher)
    {
        System.out.println(teacher);
        teacherRepository.save(teacher);
    }

    public void deleteTeacher(int teacherId)
    {
        if(!teacherRepository.existsById(teacherId))
        {
            return;
        }
        teacherRepository.deleteById(teacherId);
    }
    @Transactional
    public void updateTeacher(int teacherId, String fName, String lName, double salary, int year, String cond)
    {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() ->new IllegalStateException("no teacher"));
        teacher.setfName(fName);
        teacher.setlName(lName);
        teacher.setSalary(salary);
        teacher.setYear(year);
        teacher.setCond(cond);
    }
    public void printToCsv()
    {
        List<Teacher> teachers = teacherRepository.findAll();
        try (CSVWriter writer = new CSVWriter(new FileWriter("teachers.csv")))
        {
            for (Teacher t: teachers)
            {
                String[] line = new String[]{t.toString()};
                writer.writeNext(line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
