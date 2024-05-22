package com.ricka.princy.repository;

import com.ricka.princy.entity.Unit;
import com.ricka.princy.fjpa.FJPARepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class UnitRepository extends FJPARepository<Unit> {
    public UnitRepository(Connection connection) {
        super(connection);
    }
}