package com.example.student.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Vegetable;
import com.example.student.repository.VegetableRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class VegetableController {
    @Autowired
    VegetableRepo repo;
    @GetMapping("/vegetable")
    public List<Vegetable> getAllVegetables()
    {
        List<Vegetable> vegetables =repo.findAll();
        return vegetables;
    }
    @GetMapping("/s/{id}")
    public Vegetable getStudent(@PathVariable int id)
    {
        Vegetable vegetables = repo.findById(id).get();
        return vegetables;
    }
    @PostMapping("/vegetable/add")
    public void createStudent(@RequestBody Vegetable vegetables)
    {
        repo.save(vegetables);
    }
    @PutMapping("/vegetable/update/{id}")
    public void updateStudent(@PathVariable int id)
    {
        Vegetable vegetables = repo.findById(id).get();
        vegetables.setName("carrot");;
        vegetables.setPrice("50");;
        vegetables.setQuantity(1);
        repo.save(vegetables);
    }
    @DeleteMapping("/vegetable/delete/{id}")
    public void deleteStudent(@PathVariable int id)
    {
        Vegetable vegetables= repo.findById(id).get();
        repo.delete(vegetables);
    }
}
