package com.ricka.princy.service.model;

import com.ricka.princy.entity.IngredientTemplate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock implements Serializable {
    private IngredientTemplate ingredientTemplate;
    private BigDecimal quantity;
}