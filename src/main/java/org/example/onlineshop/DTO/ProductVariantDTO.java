package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import org.example.onlineshop.Entity.*;

import java.util.List;

public class ProductVariantDTO {
    private Double price;
    private Integer quantity;
    private ProductDTO product;
    private ColorDTO color;

    private SizeDTO size;

    private List<CartItemDTO> cartItems;

    private List<OrderItemDTO> orderItems;
}
