package com.ricka.princy.service;

import com.ricka.princy.entity.StockTransaction;
import com.ricka.princy.repository.StockTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockTransactionService {
    private final StockTransactionRepository stockTransactionRepository;

    public List<StockTransaction> saveAll(List<StockTransaction> stockTransactions){
        try {
            return this.stockTransactionRepository.saveOrUpdateAll(stockTransactions);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StockTransaction> getAllByRestaurantId(String restaurantId){
        try {
            return this.stockTransactionRepository.findByRestaurantId(restaurantId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
