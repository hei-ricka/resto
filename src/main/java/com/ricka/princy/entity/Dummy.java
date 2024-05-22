package com.ricka.princy.entity;

import com.ricka.princy.fjpa.annotation.Column;
import com.ricka.princy.fjpa.annotation.Entity;
import com.ricka.princy.fjpa.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dummy implements Serializable {
    @Id
    @Column
    private String id;

    @Column
    private String name;
}