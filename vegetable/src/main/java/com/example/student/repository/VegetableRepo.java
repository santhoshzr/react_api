package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.model.Vegetable;

public interface VegetableRepo extends JpaRepository<Vegetable,Integer>{

    
}
