package com.spring.crudSpringDemo.repository;

import com.spring.crudSpringDemo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {













    /*public Student saveStudent(Student studentReq) {
        System.out.println("repository");

        Student s1 = new Student();
        s1.setName("Renuka");
        s1.setAge(28);
        s1.setEmail("renuka@gmail.com");
        s1.setRollNo(21);
        s1.setSubject("Spring boot");

        return s1;
    }*/
}
