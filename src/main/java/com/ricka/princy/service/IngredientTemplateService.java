package com.ricka.princy.service;

import com.ricka.princy.entity.IngredientTemplate;
import com.ricka.princy.exception.InternalServerErrorException;
import com.ricka.princy.exception.NotFoundException;
import com.ricka.princy.repository.IngredientTemplateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class IngredientTemplateService {
    private final IngredientTemplateRepository ingredientTemplateRepository;

    public List<IngredientTemplate> getAll(){
        try{
            return this.ingredientTemplateRepository.findAll();
        }catch (SQLException e){
            throw new InternalServerErrorException(e);
        }
    }

    public IngredientTemplate getOne(String id){
        try {
            var ingredientTemplate = this.ingredientTemplateRepository.findById(id);
            if(ingredientTemplate == null) throw new NotFoundException();
            return ingredientTemplate;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<IngredientTemplate> saveOrUpdateAll(List<IngredientTemplate> ingredientTemplates){
        try {
            return this.ingredientTemplateRepository.saveOrUpdateAll(ingredientTemplates);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}