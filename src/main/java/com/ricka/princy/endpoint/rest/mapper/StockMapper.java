package com.ricka.princy.endpoint.rest.mapper;

import com.ricka.princy.endpoint.rest.model.CreateSupply;
import com.ricka.princy.entity.StockTransaction;
import com.ricka.princy.service.IngredientTemplateService;
import com.ricka.princy.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class StockMapper {
    private final RestaurantService restaurantService;
    private final IngredientTemplateService ingredientTemplateService;

    public List<StockTransaction> createSupplyToDomain(String restaurantId, CreateSupply createSupply){
        var stockTransactions = new ArrayList<StockTransaction>();
        var restaurant = this.restaurantService.getOne(restaurantId);

        for(var toCreate : createSupply.getStocks()){
            var ingredientTemplate = this.ingredientTemplateService.getOne(toCreate.getIngredientTemplateId());
            stockTransactions.add(StockTransaction
                .builder()
                    .id(UUID.randomUUID().toString())
                    .quantity(toCreate.getQuantity())
                    .ingredientTemplate(ingredientTemplate)
                    .restaurant(restaurant)
                    .transactionDatetime(createSupply.getSupplyDatetime())
                .build()
            );
        }

        return stockTransactions;
    }
}
