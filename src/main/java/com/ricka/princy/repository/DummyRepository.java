package com.ricka.princy.repository;

import com.ricka.princy.fjpa.FJPARepository;
import com.ricka.princy.entity.Dummy;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class DummyRepository extends FJPARepository<Dummy> {
    public DummyRepository(Connection connection) {
        super(connection);
    }
}
