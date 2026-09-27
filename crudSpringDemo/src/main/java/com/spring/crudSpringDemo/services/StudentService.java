package com.spring.crudSpringDemo.services;

import com.spring.crudSpringDemo.entity.Student;
import com.spring.crudSpringDemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        //System.out.println("service");
        studentReq.setDeleted(false);
        Student studentRes = studentRepository.save(studentReq);
        //System.out.println("Exit service");
        return studentRes;
    }

    public Student getStudent(Long id) {
       Optional<Student> studentRes = studentRepository.findByIdAndDeletedIsFalse(id);

       if(studentRes.isPresent()){
           return studentRes.get();
       }
       return null;
    }


    public List<Student> getAllStudents() {
        List<Student> studList = studentRepository.findByDeletedIsFalse();

        return studList;
    }

    public Student updateStudent(Long id, Student studReq) {
        Optional<Student> existingStud = studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStud.isEmpty()){
            return null;
        }

        Student studToSave = existingStud.get();

        studToSave.setName(studReq.getName());
        studToSave.setRollNo(studReq.getRollNo());
        studToSave.setSubject(studReq.getSubject());
        studToSave.setEmail(studReq.getEmail());
        studToSave.setAge(studReq.getAge());
        studToSave.setDeleted(false);

        return studentRepository.save(studToSave);
    }


    public Boolean deleteStudent(Long id) {
        Boolean isStud = studentRepository.existsById(id);

        if(!isStud) return false;

        studentRepository.deleteById(id);

        return true;

    }

    public Boolean deleteStudentSoftly(Long id) {
        Optional<Student> isStudExists = studentRepository.findByIdAndDeletedIsFalse(id);

        if(isStudExists.isEmpty()) return false;

        Student studToSave =  isStudExists.get();

        studToSave.setDeleted(true);

        studentRepository.save(studToSave);

        return true;
    }
}
