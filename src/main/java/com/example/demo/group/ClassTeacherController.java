package com.example.demo.group;

import com.example.demo.rating.Rating;
import com.example.demo.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/group")
public class ClassTeacherController {
private final ClassTeacherService classTeacherService;

    @Autowired
    public ClassTeacherController(ClassTeacherService classTeacherService)
    {
        this.classTeacherService = classTeacherService;
    }
    @GetMapping
    public List<ClassTeacher> getClasses()
    {
        return classTeacherService.getClasses();
    }
    @GetMapping(path="/{groupId}/teacher")
    public List<Teacher> getTeachers(@PathVariable("groupId") int groupId)
    {
        return classTeacherService.getTeachers((groupId));
    }
    @GetMapping(path="/{groupId}/fill")
    public double getFill(@PathVariable("groupId") int groupId)
    {
        return classTeacherService.getFill((groupId));
    }
    @PostMapping
    public void addClass(@RequestBody ClassTeacher classTeacher)
    {
        classTeacherService.addNewClass(classTeacher);
    }
    @DeleteMapping(path = "/{groupId}")
    public void deleteClass(@PathVariable("groupId") int groupId)
    {
        classTeacherService.deleteClass(groupId);
    }
}
