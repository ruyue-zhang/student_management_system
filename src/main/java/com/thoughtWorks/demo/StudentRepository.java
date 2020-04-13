package com.thoughtWorks.demo;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends CrudRepository<Student, String> {
    @Modifying
    @Query("INSERT INTO student(name,gender,grade) values(:name,:gender,:grade)")
    int insert(@Param("name") String name, @Param("gender") String gender, @Param("grade") String grade);
}
