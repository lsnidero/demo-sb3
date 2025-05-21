package com.example.demo.repository;

import com.example.demo.entity.ConfigurationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends CrudRepository<ConfigurationEntity, Long> {

    ConfigurationEntity findByName(String name);
}
