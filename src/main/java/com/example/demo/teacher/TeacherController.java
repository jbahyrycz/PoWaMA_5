package com.example.demo.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/teacher")
public class TeacherController {
private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService)
    {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getTeachers()
    {
        return teacherService.getTeachers();
    }
    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher)
    {
        teacherService.addNewTeacher(teacher);
    }
    @DeleteMapping(path = "/{teacherId}")
    public void deleteTeacher(@PathVariable("teacherId") int teacherId)
    {
        teacherService.deleteTeacher(teacherId);
    }
    @PutMapping(path = "/{teacherId}")
    public void updateTeacher(@PathVariable("teacherId") int teacherId,@RequestBody Teacher teacher)
    {
        teacherService.updateTeacher(teacherId, teacher.getfName(), teacher.getlName(), teacher.getSalary(), teacher.getYear(), teacher.getCond());
    }
    @GetMapping(path = "/csv")
    public void printToCsv()
    {
        teacherService.printToCsv();
    }
}
