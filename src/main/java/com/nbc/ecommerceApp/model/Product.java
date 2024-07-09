package com.nbc.ecommerceApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Product {

    @Id
    private int id;
    private String name;
    private double price;
}
