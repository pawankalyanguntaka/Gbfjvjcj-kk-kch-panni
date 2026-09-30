package com.hallease.api.controller;
import com.hallease.api.model.Hall;
import com.hallease.api.repo.HallRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/halls")
@CrossOrigin(origins="*")
public class HallController {
    private final HallRepository repo;
    public HallController(HallRepository repo){this.repo=repo;}
    @GetMapping public List<Hall> all(){return repo.findAll();}
}