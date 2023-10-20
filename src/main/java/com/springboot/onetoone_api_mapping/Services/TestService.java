package com.springboot.onetoone_api_mapping.Services;

import com.springboot.onetoone_api_mapping.Dao.BookRepositoty;
import com.springboot.onetoone_api_mapping.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Component
public class TestService {

    @Autowired
    BookRepositoty bookRepositoty;
    public Iterable<Student> getAll()
    {
        Iterable<Student> list =  bookRepositoty.findAll();
        return list;
    }

    public Student addStudent(Student student) {
        bookRepositoty.save(student);
        return student;
    }

    public void deleteStudent (int id) {
        bookRepositoty.deleteById(id);
    }

    public Student updateStudent(int id,Student student)
    {
        Student student1 = bookRepositoty.findById(id);
        student1.setName(student.getName());
        student1.setAadharId(student.getAadharId());
        bookRepositoty.save(student1);
        return student1;
    }

}
