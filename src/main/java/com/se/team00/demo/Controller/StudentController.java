package com.se.team00.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.se.team00.demo.Entity.Student;
import com.se.team00.demo.Repository.StudentRepository;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/Stus")
    public Collection<Student> Stus() {
        return studentRepository.findAll().stream().collect(Collectors.toList());
    }

}