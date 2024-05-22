package com.ricka.princy.entity;

import com.ricka.princy.fjpa.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(tableName = "ingredient_template")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngredientTemplate implements Serializable {
    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    @Relation
    @ValueGetter
    private Unit unit;
}