package com.thoughtWorks.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {
    Map<String,Student> studentMap = new LinkedHashMap<>();

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        if(studentMap.containsKey(student.getName())) {
            return new String("姓名重复");
        } else {
            studentMap.put(student.getName(),student);
            return new String("添加成功");
        }
    }

    @GetMapping("/queryAll")
    public List<Student> queryAll() {
        return new ArrayList<>(studentMap.values());
    }

    @GetMapping("/query")
    public Student queryByName(@RequestParam(name = "name") String name) {
        return studentMap.get(name);
    }

    @DeleteMapping("/delete")
    public String deleteByName(@RequestParam(name = "name") String name) {
        if(studentMap.containsKey(name)) {
            studentMap.remove(name);
            return new String("删除成功");
        } else {
            return new String("该学生不存在");
        }
    }
}
