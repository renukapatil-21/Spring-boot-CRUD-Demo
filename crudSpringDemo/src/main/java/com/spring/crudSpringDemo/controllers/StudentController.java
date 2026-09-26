package com.spring.crudSpringDemo.controllers;

import com.spring.crudSpringDemo.entity.Student;
import com.spring.crudSpringDemo.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    /*@GetMapping()
    public ResponseEntity<Student> getStudent(){

        List<Student> students = new ArrayList<>();

        return ResponseEntity.ok(students);
    }*/

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){

        Student createdStudent =  studentService.createStudent(student);
        System.out.println("controller");

        return createdStudent;
    }


}
