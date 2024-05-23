package com.ricka.princy.endpoint.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CreateStockTransaction implements Serializable {
    private BigDecimal quantity;
    private String ingredientTemplateId;
}