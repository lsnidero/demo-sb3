package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
