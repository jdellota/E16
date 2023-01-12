package com.example.demo.controller;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService  studentService;

    @PostMapping(path="/student")
    public @ResponseBody String addStudent (@RequestParam String firstName,
            @RequestParam String lastName, @RequestParam String email, @RequestParam String course){
        return studentService.addStudent(firstName, lastName, email, course);

    }

    @GetMapping(path="/students")
    public @ResponseBody Iterable<StudentEntity> getAllStudents() {

        return studentService.findAllStudents();
    }

    @GetMapping(path= "/studentid")
    public ResponseEntity<List<StudentEntity>> findStudent(@RequestParam int id) {

        return studentService.findByID(id);
    }
}
