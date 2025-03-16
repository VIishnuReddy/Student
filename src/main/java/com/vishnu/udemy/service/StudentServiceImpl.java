package com.vishnu.udemy.service;

import com.vishnu.udemy.DAO.StudentDAO;
import com.vishnu.udemy.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentDAO studentDAO;
    public StudentServiceImpl(StudentDAO studentDAO){
        this.studentDAO=studentDAO;
    }
    @Override
    public List<Student> getStudentList() {
        return studentDAO.getStudentList();
    }

    @Override
    public Student findStudentById(int id) {
        return studentDAO.findStudentById(id);
    }

    @Transactional
    @Override
    public void deleteStudentById(int id) {
        studentDAO.deleteStudentById(id);
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return studentDAO.save(student);
    }

}
