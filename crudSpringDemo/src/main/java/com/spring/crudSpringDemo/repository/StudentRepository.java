package com.spring.crudSpringDemo.repository;

import com.spring.crudSpringDemo.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {



    public Student saveStudent(Student studentReq) {
        System.out.println("repository");
        return null;
    }
}
