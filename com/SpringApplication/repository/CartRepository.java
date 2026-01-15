package com.SpringApplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringApplication.model.Cart;

import java.util.Optional;
import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserIdAndProductId(Long userId, Long productId);
    List<Cart> findByUserId(Long userId);
}
