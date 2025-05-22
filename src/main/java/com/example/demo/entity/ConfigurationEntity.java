package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
