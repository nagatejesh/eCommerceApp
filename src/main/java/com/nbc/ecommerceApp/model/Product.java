package com.nbc.ecommerceApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Product {

    @Id
    private int id;
    private String name;
    private BigDecimal price;
}
