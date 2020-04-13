package com.thoughtWorks.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student) {
        if(studentRepository.existsById(student.getName())) {
            return new String("姓名重复");
        } else {
            studentRepository.insert(student.getName(),student.getGender(),student.getGrade());
            return new String("添加成功");
        }
    }

    public Iterable<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    public Optional<Student> queryById(String name) {
        return studentRepository.findById(name);
    }

    public String deleteById(String name) {
        if(studentRepository.existsById(name)) {
            studentRepository.deleteById(name);
            return new String("删除成功");
        } else {
            return new String("该学生不存在");
        }
    }

}
