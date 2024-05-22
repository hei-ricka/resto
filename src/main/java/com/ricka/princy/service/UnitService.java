package com.ricka.princy.service;

import com.ricka.princy.entity.Unit;
import com.ricka.princy.exception.InternalServerErrorException;
import com.ricka.princy.exception.NotFoundException;
import com.ricka.princy.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitService {
    private final UnitRepository unitRepository;

    public List<Unit> getAll(){
        try{
            return this.unitRepository.findAll();
        }catch (SQLException e){
            throw new InternalServerErrorException(e);
        }
    }

    public Unit getOne(String id){
        try {
            var unit = this.unitRepository.findById(id);
            if(unit == null) throw new NotFoundException();
            return unit;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Unit> saveOrUpdateAll(List<Unit> units){
        try {
            return this.unitRepository.saveOrUpdateAll(units);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}