package com.app.api.mapper;

import com.app.api.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductMapper {
    private Integer productId;
    private String name;
    private Double price;
    private String brand;
    //private LocalDate fvencimiento;
    private Integer stock;

    public ProductMapper(Product product) {
        this(product.getProductId(),
                product.getName(),
                product.getPrice(),
                product.getBrand(),
                product.getStock());
    }
}
