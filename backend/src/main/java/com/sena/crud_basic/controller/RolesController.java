package com.sena.crud_basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sena.crud_basic.service.RolesService;
import com.sena.crud_basic.model.roles;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;

    @GetMapping
    public List<roles> getAll() {
        return rolesService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<roles> getById(@PathVariable int id) {
        return rolesService.getById(id);
    }

    @PostMapping
    public roles save(@RequestBody roles roles) {
        return rolesService.save(roles);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        rolesService.delete(id);
    }
}