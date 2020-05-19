package com.example.springangularcrud.dao;

import com.example.springangularcrud.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Studentdao extends CrudRepository<Student, Long> {
}
