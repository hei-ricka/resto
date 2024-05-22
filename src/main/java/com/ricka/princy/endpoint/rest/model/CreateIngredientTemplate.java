package com.ricka.princy.endpoint.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateIngredientTemplate implements Serializable{
    private String id;
    private String name;
    private String unitId;
}