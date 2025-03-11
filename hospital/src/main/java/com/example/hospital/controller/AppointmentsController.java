package com.example.hospital.controller;

import com.example.hospital.model.Appointments;
import com.example.hospital.service.AppointmentsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/appointments")
public class AppointmentsController {
    private final AppointmentsService service;

    public AppointmentsController(AppointmentsService service) {
        this.service = service;
    }

    @GetMapping
    public List<Appointments> getAllAppointments() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Appointments> getAppointmentById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Appointments createAppointment(@RequestBody Appointments appointment) {
        return service.save(appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable int id) {
        service.deleteById(id);
    }
}
