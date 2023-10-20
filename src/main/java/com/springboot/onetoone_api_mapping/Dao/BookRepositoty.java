package com.springboot.onetoone_api_mapping.Dao;

import com.springboot.onetoone_api_mapping.Entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoty extends CrudRepository<Student,Integer> {

    public Student findById(int id);
}
