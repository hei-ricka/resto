package com.ricka.princy.repository;

import com.ricka.princy.entity.IngredientTemplate;
import com.ricka.princy.fjpa.FJPARepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class IngredientTemplateRepository extends FJPARepository<IngredientTemplate> {
    public IngredientTemplateRepository(Connection connection) {
        super(connection);
    }
}
