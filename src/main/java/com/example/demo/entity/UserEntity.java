package com.example.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "USERS")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(generator="USERS_SEQ")
    @SequenceGenerator(name="USERS_SEQ",sequenceName="USERS_SEQ", allocationSize=1)
    private long id;

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column(name = "EXTERNAL_ID")
    private String externalId;
    @Column
    private int age;
}
