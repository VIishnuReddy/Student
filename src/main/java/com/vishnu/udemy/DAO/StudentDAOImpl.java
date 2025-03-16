package com.vishnu.udemy.DAO;

import com.vishnu.udemy.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager em;

    public StudentDAOImpl(EntityManager em) {
        this.em = em;
    }
    @Override
    @Transactional
    public Student save(Student student) {
       Student s=em.merge(student);
       return s;
    }

    @Override
    public List<Student> getStudentList() {
        TypedQuery<Student> query = em.createQuery("select s from Student s", Student.class);
        List<Student> studentList = query.getResultList();
        return studentList;
    }

    @Override
    public Student findStudentById(int id) {
       return em.find(Student.class, id);
    }

    @Override
    public void deleteStudentById(int id) {
       Student student=findStudentById(id);
       if(student!=null) {
           em.remove(student);
       }
    }


}
