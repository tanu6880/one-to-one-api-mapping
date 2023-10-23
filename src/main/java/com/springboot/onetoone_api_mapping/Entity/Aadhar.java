package com.springboot.onetoone_api_mapping.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Aadhar")
public class Aadhar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addharId;
    private String name;
    private String dob;

    @OneToOne(mappedBy = "aadharId")
    @JsonBackReference
    private Student student;
    public Aadhar() {
    }


    public Aadhar(int addharId, String name, String dob) {
        this.addharId = addharId;
        this.name = name;
        this.dob = dob;
    }

    public int getAddharId() {
        return addharId;
    }

    public void setAddharId(int addharId) {
        this.addharId = addharId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Aadhar{" +
                "addharId=" + addharId +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
