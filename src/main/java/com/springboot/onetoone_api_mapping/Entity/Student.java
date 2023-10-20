package com.springboot.onetoone_api_mapping.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Aadhar aadharId;

    public Student() {
    }

    public Student(int id, String name, Aadhar aadharId) {
        this.id = id;
        this.name = name;
        this.aadharId = aadharId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Aadhar getAadharId() {
        return aadharId;
    }

    public void setAadharId(Aadhar aadharId) {
        this.aadharId = aadharId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", aadharId=" + aadharId +
                '}';
    }
}
