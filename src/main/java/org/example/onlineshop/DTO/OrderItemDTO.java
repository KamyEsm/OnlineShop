package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import org.example.onlineshop.Entity.Order;
import org.example.onlineshop.Entity.ProductVariant;

public class OrderItemDTO {
    private Integer quantity;

    private Double price;

    private ProductVariantDTO productVariant;

    private OrderDTO order;

}
