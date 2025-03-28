package com.vishnu.udemy.controller;

import com.vishnu.udemy.entity.Student;
import com.vishnu.udemy.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("springMVC")
public class SpringMVCController {

    private StudentService studentService;

    public SpringMVCController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students")
    public String getStudent(Model model) {
        // get employees from DB
        List<Student> students =studentService.getStudentList();
        // add list of employees to the spring model
        model.addAttribute("students", students);
        return "students-list";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-form";
    }

    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam ("id") int id, Model model){
    Student student= studentService.findStudentById(id);
    System.out.println(student.getId());
    model.addAttribute("student", student);
        return "student-form";
    }

    @PostMapping("save")
    public String SaveStudent(@ModelAttribute("student") Student student){
        studentService.save(student);
        return "redirect:students";
    }

    @GetMapping("deleteStudent")
    public String DeleteStudent(@RequestParam ("id") int id){
        studentService.deleteStudentById(id);
        return "redirect:students";
    }
}
