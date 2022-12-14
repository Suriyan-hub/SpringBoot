package com.web;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.web.model.Student;

@RepositoryRestResource(collectionResourceRel = "students",path="students")
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
