package com.vishnu.udemy.service;

import com.vishnu.udemy.entity.Student;

import java.util.List;

public interface StudentService {

   List<Student> getStudentList();

   Student findStudentById(int id);

   void deleteStudentById(int id);

   Student save(Student student);
}
