package com.ricka.princy.entity;

import com.ricka.princy.fjpa.annotation.Column;
import com.ricka.princy.fjpa.annotation.Entity;
import com.ricka.princy.fjpa.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant {
    @Id
    @Column
    private String id;

    @Column
    private String name;

    @Column
    private String location;
}