package com.fadhili.Ecommerce.records;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.fadhili.Ecommerce.models.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record ProductInput(
    @NotEmpty String name,
    @NotEmpty String brand, 
    @NotEmpty String details,
    @Min(0) BigDecimal price,
    @JsonProperty("category_id") Integer categoryId
) {

    public Product toModel() {
        Product product = new Product();
        BeanUtils.copyProperties(this, product);
        return product;
    }

}
