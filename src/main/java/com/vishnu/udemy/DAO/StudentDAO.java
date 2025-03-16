package com.vishnu.udemy.DAO;

import com.vishnu.udemy.entity.Student;

import java.util.List;

public interface StudentDAO{
    Student save(Student student);
    List<Student> getStudentList();
    Student findStudentById(int id);

    void deleteStudentById(int id);

}
