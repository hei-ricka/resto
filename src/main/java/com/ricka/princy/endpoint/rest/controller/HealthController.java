package com.ricka.princy.endpoint.rest.controller;

import com.ricka.princy.entity.Dummy;
import com.ricka.princy.repository.DummyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HealthController {
    private final DummyRepository dummyRepository;

    @GetMapping("/dummies")
    public List<Dummy> getDummies() throws SQLException {
        return dummyRepository.findAll();
    }

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }
}
