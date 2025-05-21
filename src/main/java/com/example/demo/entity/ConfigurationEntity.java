package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "CONFIGURATION")
@Data
public class ConfigurationEntity {

    @Id
    @GeneratedValue(generator="CONFIGURATION_SEQ")
    @SequenceGenerator(name="CONFIGURATION_SEQ",sequenceName="CONFIGURATION_SEQ", allocationSize=1)
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String value;
}
