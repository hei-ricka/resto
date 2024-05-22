package com.ricka.princy.endpoint.rest.controller;

import com.ricka.princy.endpoint.rest.mapper.IngredientTemplateMapper;
import com.ricka.princy.endpoint.rest.model.CreateIngredientTemplate;
import com.ricka.princy.entity.IngredientTemplate;
import com.ricka.princy.service.IngredientTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientTemplateService ingredientTemplateService;
    private final IngredientTemplateMapper ingredientTemplateMapper;

    @GetMapping("/ingredients/templates")
    public List<IngredientTemplate> getAllTemplates(){
        return this.ingredientTemplateService.getAll();
    }

    @GetMapping("/ingredients/templates/{id}")
    public IngredientTemplate getOneTemplates(@PathVariable String id){
        return this.ingredientTemplateService.getOne(id);
    }

    @PutMapping("/ingredients/templates")
    public List<IngredientTemplate> saveOrUpdateAllTemplates(@RequestBody List<CreateIngredientTemplate> toCreates){
        return this.ingredientTemplateService.saveOrUpdateAll(
            toCreates.stream().map(ingredientTemplateMapper::createToDomain).toList()
        );
    }
}