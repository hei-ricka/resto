package com.ricka.princy.endpoint.rest.controller;

import com.ricka.princy.entity.Unit;
import com.ricka.princy.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UnitController {
    private final UnitService unitService;

    @GetMapping("/units")
    public List<Unit> getAll(){
        return this.unitService.getAll();
    }

    @GetMapping("/units/{id}")
    public Unit getOne(@PathVariable String id){
        return this.unitService.getOne(id);
    }

    @PutMapping("/units")
    public List<Unit> saveOrUpdateAll(@RequestBody List<Unit> units){
        return this.unitService.saveOrUpdateAll(units);
    }
}