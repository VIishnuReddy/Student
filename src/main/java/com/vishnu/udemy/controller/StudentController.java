package com.vishnu.udemy.controller;

import com.vishnu.udemy.DAO.StudentDAO;
import com.vishnu.udemy.entity.Student;
import com.vishnu.udemy.exception.StudentErrorResponse;
import com.vishnu.udemy.exception.StudentNotFoundException;
import com.vishnu.udemy.service.StudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("studentService")
public class StudentController {
    private final View error;
    private StudentService studentService;

    public StudentController(StudentService studentService,View error) {
        this.studentService = studentService;
        this.error = error;
    }


    @GetMapping("students")
    public List<Student> getStudents() {
      return studentService.getStudentList();
    }

    @GetMapping("student/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentService.findStudentById(id);
    }
    @DeleteMapping("removeStudent/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok("Student deleted successfully");
    }

    @PostMapping("/students")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        Student s= studentService.save(student);
        return ResponseEntity.ok("Student added successfully");
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.save(student);
    }
//
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex){
//        StudentErrorResponse ser= new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(),
//                                                            System.currentTimeMillis());
//
//        return new ResponseEntity<>(ser, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception ex){
//        StudentErrorResponse ser= new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), "not a valid id, Please give a number",
//                System.currentTimeMillis());
//
//        return new ResponseEntity<>(ser, HttpStatus.BAD_REQUEST);
//    }
}
