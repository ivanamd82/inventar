package com.example.inventar.controller;

import com.example.inventar.model.Computer;
import com.example.inventar.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComputerRegistrationController {

    @Autowired
    private ComputerRepository computerRepository;

    @PostMapping("/computers")
    public Computer addNewComputer(@RequestBody Computer newComputer) {
        return computerRepository.save(newComputer);
    }

    @GetMapping("computers")
    public List<Computer> getAllComputers() {
        return computerRepository.findAll();
    }
}
