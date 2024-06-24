package com.fadhili.Ecommerce.models.enums;

public enum StockType {
    
    ENTRY("ENTRY"), OUTPUT("OUTPUT"), EXPIRED("EXPIRED");

    public String value;

    private StockType(String value) {
        this.value = value;
    }

}
