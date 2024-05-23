package com.ricka.princy.repository;

import com.ricka.princy.entity.StockTransaction;
import com.ricka.princy.fjpa.FJPARepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StockTransactionRepository extends FJPARepository<StockTransaction> {
    public StockTransactionRepository(Connection connection) {
        super(connection);
    }

    public List<StockTransaction> findByRestaurantId(String restaurantId) throws SQLException {
        return this.findByCondition("@restaurant = ?", List.of(restaurantId));
    }

    public List<StockTransaction> findByRestaurantIdAndTemplateId(String restaurantId, String templateId) throws SQLException {
        return this.findByCondition("@restaurant = ? and @ingredientTemplate = ?", List.of(restaurantId, templateId));
    }

    @Override
    public List<StockTransaction> findByCondition(String condition, List<Object> values, String suffix, List<Class<?>> excludes) throws SQLException {
        return super.findByCondition(condition, values, suffix + " order by @transactionDatetime desc", excludes);
    }
}