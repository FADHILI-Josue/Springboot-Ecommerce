package com.dalmofelipe.Ecommerce.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalmofelipe.Ecommerce.exceptions.BadRequestException;
import com.dalmofelipe.Ecommerce.models.Product;
import com.dalmofelipe.Ecommerce.models.Stock;
import com.dalmofelipe.Ecommerce.records.StockControl;
import com.dalmofelipe.Ecommerce.repositories.ProductRepository;

@Component
public class StockMapperDecorator implements StockMapper {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Stock toModel(StockControl stockControl) {
        if (stockControl == null) {
            return null;
        }

        Stock stock = new Stock();
        
        stock.setAmount(stockControl.amount() != 0 ? stockControl.amount() : null);
        stock.setType(stockControl.type());
        stock.setValidUntil(stockControl.validUntil());

        Product product = productRepository.findById(stockControl.productId())
            .orElseThrow(() -> new BadRequestException("product not found in mapper decorator"));
        
        stock.setProduct(product);

        return stock;
    }
}