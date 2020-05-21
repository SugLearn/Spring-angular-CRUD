package com.example.springangularcrud.controller;

import com.example.springangularcrud.dao.Studentdao;
import com.example.springangularcrud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    private Studentdao dao;

    @GetMapping("/getStudents")
    public List<Student> getAllStudents(){
        return (List<Student>) dao.findAll();
    }

    @PostMapping("/Students")
    public Student createStudentList(@Valid @RequestBody Student student){
        return dao.save(student);
    }

    @GetMapping("/getStudentsById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long StudentId){
        Student student = dao.findById(StudentId).orElse(null);
        return ResponseEntity.ok().body(student);

    }

    @DeleteMapping("/deleteStudent/{id}")
    public Map<String,Boolean> deleteStudents(@PathVariable(value = "id") Long StudentId) {
        Student student = dao.findById(StudentId).orElse(null);
        dao.delete(student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }

    @PutMapping("UpdateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value= "id") Long StudentId,
                                                 @Valid @RequestBody Student studentdetails){
        Student student = dao.findById(StudentId).orElse(null);
        student.setEmailId(studentdetails.getEmailId());
        student.setFirstName(studentdetails.getFirstName());
        student.setLastName(studentdetails.getLastName());
        final Student updatedStudents = dao.save(student);
        return ResponseEntity.ok(updatedStudents);

    }

}
