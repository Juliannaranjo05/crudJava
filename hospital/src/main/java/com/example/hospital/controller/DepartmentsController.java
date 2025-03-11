package com.example.hospital.controller;

import com.example.hospital.model.Departments;
import com.example.hospital.service.DepartmentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departments")
public class DepartmentsController {
    private final DepartmentsService service;

    public DepartmentsController(DepartmentsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Departments> getAllDepartments() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Departments> getDepartmentById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Departments createDepartment(@RequestBody Departments department) {
        return service.save(department);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable int id) {
        service.deleteById(id);
    }
}
