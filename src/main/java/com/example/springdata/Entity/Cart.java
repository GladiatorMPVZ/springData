package com.example.springdata.Entity;

import com.example.springdata.Entity.Product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cart")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;

    @Column (name = "quantity")
    private Long quantity;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;
}