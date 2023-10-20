package com.springboot.onetoone_api_mapping.Controller;

import com.springboot.onetoone_api_mapping.Entity.Student;
import com.springboot.onetoone_api_mapping.Services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/student")
    public ResponseEntity<Iterable<Student>> getAll()
    {
        try
        {

                return ResponseEntity.of(Optional.of(testService.getAll()));
//            else
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        try
        {
            Student student1 = testService.addStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable("id") int id)
    {
        try
        {
            testService.deleteStudent(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> UpdateStudent(@PathVariable("id") int id, @RequestBody Student student)
    {
        try
        {
            return ResponseEntity.ok(testService.updateStudent(id,student));
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
