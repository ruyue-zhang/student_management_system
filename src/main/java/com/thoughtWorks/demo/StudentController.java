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
    Map<String,Student> studentMap = new LinkedHashMap<>();

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        if(studentRepository.existsById(student.getName())) {
            return new String("姓名重复");
        } else {
            studentRepository.insert(student.getName(),student.getGender(),student.getGrade());
            return new String("添加成功");
        }
    }

    @GetMapping("/findAll")
    public Iterable<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/query")
    public Optional<Student> queryById(@RequestParam(name = "name") String name) {
        return studentRepository.findById(name);
    }

    @DeleteMapping("/delete")
    public String deleteById(@RequestParam(name = "name") String name) {
        if(studentRepository.existsById(name)) {
            studentRepository.deleteById(name);
            return new String("删除成功");
        } else {
            return new String("该学生不存在");
        }
    }
}
