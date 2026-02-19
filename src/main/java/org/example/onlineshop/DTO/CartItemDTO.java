package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import org.example.onlineshop.Entity.Cart;
import org.example.onlineshop.Entity.ProductVariant;

public class CartItemDTO {
    private Integer quantity;
    private ProductVariantDTO productVariant;
    private CartDTO cart;

}
