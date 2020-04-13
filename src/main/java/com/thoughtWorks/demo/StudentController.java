package com.thoughtWorks.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        try {
            return studentServices.addStudent(student);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    @GetMapping("/findAll")
    public Iterable<Student> findAllStudent() {
        try {
            return studentServices.findAllStudent();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/query")
    public Optional<Student> queryById(@RequestParam(name = "name") String name) {
        try {
            return studentServices.queryById(name);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam(name = "name") String name) {
        try {
            return studentServices.deleteById(name);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}
