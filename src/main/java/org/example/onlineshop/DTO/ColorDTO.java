package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import org.example.onlineshop.Entity.ProductVariant;

import java.util.List;

public class ColorDTO {
    private String color;
    private List<ProductVariantDTO> productVariant;
}
