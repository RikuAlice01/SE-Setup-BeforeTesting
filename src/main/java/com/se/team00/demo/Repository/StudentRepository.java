package com.se.team00.demo.repository;

import com.se.team00.demo.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface StudentRepository extends JpaRepository<Student, Long> {
    public Student findByStudentId(String studentId);
}