package com.ricka.princy.service;

import com.ricka.princy.entity.Restaurant;
import com.ricka.princy.exception.InternalServerErrorException;
import com.ricka.princy.exception.NotFoundException;
import com.ricka.princy.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getAll(){
        try{
            return this.restaurantRepository.findAll();
        }catch (SQLException e){
            throw new InternalServerErrorException(e);
        }
    }

    public Restaurant getOne(String id){
        try {
            var restaurant = this.restaurantRepository.findById(id);
            if(restaurant == null) throw new NotFoundException();
            return restaurant;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Restaurant> saveOrUpdateAll(List<Restaurant> restaurants){
        try {
            return this.restaurantRepository.saveOrUpdateAll(restaurants);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}