package com.dalmofelipe.Ecommerce.records;

import com.dalmofelipe.Ecommerce.models.enums.StockType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record StockControl(
    @NotNull @Min(1) Integer productId,
    @NotNull @Min(1) Integer amount, 
    @NotNull StockType type, 
    LocalDate validUntil
) {}
