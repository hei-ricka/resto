package com.ricka.princy.endpoint.rest.controller;

import com.ricka.princy.entity.Restaurant;
import com.ricka.princy.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getAll(){
        return this.restaurantService.getAll();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant getOne(@PathVariable String id){
        return this.restaurantService.getOne(id);
    }

    @PutMapping("/restaurants")
    public List<Restaurant> saveOrUpdateAll(@RequestBody List<Restaurant> restaurants){
        return this.restaurantService.saveOrUpdateAll(restaurants);
    }
}