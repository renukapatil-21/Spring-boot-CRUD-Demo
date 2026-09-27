package com.spring.crudSpringDemo.controllers;

import com.spring.crudSpringDemo.entity.Student;
import com.spring.crudSpringDemo.services.StudentService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        Student createdStudent =  studentService.createStudent(student);
        //System.out.println("controller");

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }


    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studRes = studentService.getStudent(id);

        if(studRes == null){
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studRes);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studList = studentService.getAllStudents();

        if(studList == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studList);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody Student studReq
    ){
        Student studRes = studentService.updateStudent(id, studReq);

        if(studRes == null){
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(studRes);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(true);
    }

    @PatchMapping("/delete-soft/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudentSoftly(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Student marked as deleted");
    }

}
