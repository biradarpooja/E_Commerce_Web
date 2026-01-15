package com.SpringApplication.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringApplication.model.Cart;
import com.SpringApplication.repository.CartRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    // Add product to cart
    public Cart addCart(Cart cart) {
        Long userId = (long) cart.getUser().getId();
        Long productId = cart.getProduct().getId();

        return cartRepository.findByUserIdAndProductId(userId, productId)
            .map(existingCart -> {
                existingCart.setQuantity(existingCart.getQuantity() + cart.getQuantity());
                return cartRepository.save(existingCart);
            })
            .orElse(cartRepository.save(cart));
    }

    public List<Cart> getAllCartsByUserId(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart updateCartQuantity(Long cartId, int quantity) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
