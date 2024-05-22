package com.ricka.princy.endpoint.rest.mapper;

import com.ricka.princy.endpoint.rest.model.CreateIngredientTemplate;
import com.ricka.princy.entity.IngredientTemplate;
import com.ricka.princy.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredientTemplateMapper {
    private final UnitService unitService;

    public IngredientTemplate createToDomain(CreateIngredientTemplate toCreate){
        var unit = this.unitService.getOne(toCreate.getUnitId());
        return IngredientTemplate
                .builder()
                    .id(toCreate.getId())
                    .name(toCreate.getName())
                    .unit(unit)
                .build();
    }
}