package com.ricka.princy.endpoint.rest.controller;

import com.ricka.princy.entity.StockTransaction;
import com.ricka.princy.service.StockTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StockController {
    private final StockTransactionService stockTransactionService;

    @GetMapping("/restaurants/{restaurantId}/stocks/transactions")
    public List<StockTransaction> getRestaurantStockTransactions(@PathVariable String restaurantId){
        return this.stockTransactionService.getAllByRestaurantId(restaurantId);
    }
}
