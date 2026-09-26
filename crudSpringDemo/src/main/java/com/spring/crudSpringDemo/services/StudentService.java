package com.spring.crudSpringDemo.services;

import com.spring.crudSpringDemo.entity.Student;
import com.spring.crudSpringDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        System.out.println("service");
        Student studentRes = studentRepository.saveStudent(studentReq);
        System.out.println("Exit service");
        return studentRes;
    }

}
