package com.student.information.system.controller;

import com.student.information.system.model.Student;
import com.student.information.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value="/")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping(value="/{studentNumber}")
    public Student getStudentByNumber(@PathVariable ("studentNumber") Long studentNumber){
        return studentService.findByStudentNumber(studentNumber);
    }

    @GetMapping(value="/{email}")
    public Student getStudentByEmail (@PathVariable("email") String email){
        return studentService.findByEmail(email);
    }

    @GetMapping(value="/orderByGpa")
    public List<Student> getStudentByOrderByGpa(){
        return studentService.findAllByOrderByGpa();
    }

    @PostMapping(value= "/")
    public ResponseEntity<?> saveOrUpdateStudent (@RequestBody Student student){
        studentService.saveOrUpdateStudent(student);
        return new ResponseEntity("Student added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value="/{studentNumber}")
    public void deleteStudent(@PathVariable ("studentNumber") Long studentNumber){
        studentService.deleteStudent(studentService.findByStudentNumber(studentNumber).getId());
    }
}
