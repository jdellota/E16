package com.example.demo.service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import java.util.List;
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(String firstName, String lastName, String email, String course){
        StudentEntity student = new StudentEntity();
        student.setFirst_name(firstName);
        student.setLast_name(lastName);
        student.setEmail(email);
        student.setCourse(course);
        studentRepository.save(student);
        return "Details got Saved";
    }
    public List<StudentEntity> findAllStudents(){
        return studentRepository.findAll();
    }

    public ResponseEntity<List<StudentEntity>> findByID(int id) {

        return new ResponseEntity<>(studentRepository.findById(id), HttpStatus.OK);
    }
}
