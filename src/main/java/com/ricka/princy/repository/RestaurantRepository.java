package com.ricka.princy.repository;

import com.ricka.princy.entity.Restaurant;
import com.ricka.princy.fjpa.FJPARepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class RestaurantRepository extends FJPARepository<Restaurant> {
    public RestaurantRepository(Connection connection) {
        super(connection);
    }
}
