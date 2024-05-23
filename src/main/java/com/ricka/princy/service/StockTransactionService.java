package com.ricka.princy.service;

import com.ricka.princy.entity.StockTransaction;
import com.ricka.princy.repository.StockTransactionRepository;
import com.ricka.princy.service.model.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockTransactionService {
    private final StockTransactionRepository stockRepository;
    private final IngredientTemplateService templateService;

    public List<StockTransaction> saveAll(List<StockTransaction> stockTransactions){
        try {
            return this.stockRepository.saveOrUpdateAll(stockTransactions);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public BigDecimal getCurrentIngredientQuantity(String ingredientId,String restaurantId){
        try {
            var stockTransactions = this.stockRepository.findByRestaurantIdAndTemplateId(restaurantId, ingredientId);
            return stockTransactions.stream().map(StockTransaction::getQuantity).reduce(BigDecimal.ZERO, BigDecimal::add);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StockTransaction> getAllByRestaurantId(String restaurantId){
        try {
            return this.stockRepository.findByRestaurantId(restaurantId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Stock> getAllStockByRestaurantId(String restaurantId){
        var ingredients = this.templateService.getAll();
        return ingredients.stream().map(ingredient ->
            Stock
                .builder()
                    .ingredientTemplate(ingredient)
                    .quantity(this.getCurrentIngredientQuantity(ingredient.getId(), restaurantId))
                    .build()
        ).toList();
    }
}