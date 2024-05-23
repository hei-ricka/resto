package com.ricka.princy.entity;

import com.ricka.princy.fjpa.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity(tableName = "stock_transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockTransaction implements Serializable {
    @Id
    @Column
    private String id;

    @Relation
    @ValueGetter
    @Column(columnName = "ingredient_template")
    private IngredientTemplate ingredientTemplate;

    @Column
    @Relation
    @ValueGetter
    private Restaurant restaurant;

    @Column
    private BigDecimal quantity;

    @Column(columnName = "transaction_datetime")
    private Instant transactionDatetime;
}
