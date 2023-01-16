package com.example.demo.controller;

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;
import jakarta.transaction.Transactional;
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
            @RequestParam String lastName, @RequestParam String email, @RequestParam String course, @RequestParam String gpa){
        return studentService.addStudent(firstName, lastName, email, course, gpa);

    }

    @GetMapping(path="/students")
    public @ResponseBody Iterable<StudentEntity> getAllStudents() {

        return studentService.findAllStudents();
    }

    @GetMapping(path= "/student/{id}")
    public ResponseEntity<StudentEntity> findStudent(@PathVariable int id) {
        return studentService.findByID(id);
    }

    @PutMapping(path="/update")
    public @ResponseBody String addStudent (@RequestParam int id, @RequestParam String firstName,
                                            @RequestParam String lastName, @RequestParam String email, @RequestParam String course, @RequestParam String gpa){
        return studentService.updateStudent(id, firstName, lastName, email, course, gpa);

    }

    @PostMapping(path="/delete")
    @Transactional
    public @ResponseBody String deleteStudent (@RequestParam int id){
        return studentService.deleteStudent(id);

    }

}
