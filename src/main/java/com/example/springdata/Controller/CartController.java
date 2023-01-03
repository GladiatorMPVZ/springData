package com.example.springdata.Controller;

import com.example.springdata.Entity.Cart;
import com.example.springdata.Repository.CartRepository;
import com.example.springdata.Repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    Cart cart;
    private CartRepository cartRepository;
    private ProductRepository productRepository;


    public CartController(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @PostMapping("/add/{product_id}")
    public void add(@PathVariable Long product_id) {
        cartRepository.save(cart);
    }

    @GetMapping("/cart")
    public List<Cart> getAllProduct() {
        return cartRepository.findAll();
    }
}
