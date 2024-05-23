package com.ricka.princy.endpoint.rest.controller;

import com.ricka.princy.endpoint.rest.mapper.StockMapper;
import com.ricka.princy.endpoint.rest.model.CreateSupply;
import com.ricka.princy.entity.StockTransaction;
import com.ricka.princy.service.StockTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StockController {
    private final StockTransactionService stockTransactionService;
    private final StockMapper stockMapper;

    @GetMapping("/restaurants/{restaurantId}/stocks/transactions")
    public List<StockTransaction> getRestaurantStockTransactions(@PathVariable String restaurantId){
        return this.stockTransactionService.getAllByRestaurantId(restaurantId);
    }

    @PostMapping("/restaurants/{restaurantId}/stocks")
    public List<StockTransaction> doSupply(
        @PathVariable String restaurantId,
        @RequestBody CreateSupply createSupply
    ){
        return this.stockTransactionService.saveAll(
            stockMapper.createSupplyToDomain(restaurantId, createSupply)
        );
    }
}