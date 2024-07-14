package com.nbc.ecommerceApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
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
    @NotBlank(message = "Name of the product cannot be blank")
    private String name;
    @PositiveOrZero(message = "Price cannot be negative")
    private BigDecimal price;
}
