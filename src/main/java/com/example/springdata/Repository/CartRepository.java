package com.example.springdata.Repository;

import com.example.springdata.Entity.Cart;
import com.example.springdata.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
