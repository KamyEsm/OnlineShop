package org.example.onlineshop.DTO;

import jakarta.persistence.*;
import org.example.onlineshop.Entity.ProductVariant;

import java.util.List;

public class SizeDTO {
    private String size;
    private List<ProductVariantDTO> productVariant;
}
