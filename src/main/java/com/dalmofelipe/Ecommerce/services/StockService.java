package com.dalmofelipe.Ecommerce.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dalmofelipe.Ecommerce.exceptions.BadRequestException;
import com.dalmofelipe.Ecommerce.exceptions.BusinessException;
import com.dalmofelipe.Ecommerce.mappers.StockMapper;
import com.dalmofelipe.Ecommerce.models.Stock;
import com.dalmofelipe.Ecommerce.models.enums.StockType;
import com.dalmofelipe.Ecommerce.records.StockControl;
import com.dalmofelipe.Ecommerce.repositories.ProductRepository;
import com.dalmofelipe.Ecommerce.repositories.StockRepository;

@Service
public class StockService {

    private final ProductRepository productRepository;
    private final StockRepository stockRepository;
    protected final StockMapper stockMapper;

    public StockService(StockMapper stockMapper, StockRepository stockRepository, 
            ProductRepository productRepository) {
        this.stockMapper = stockMapper;
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
    }

    public Stock registerControl(StockControl control) {
        var stockControlModel =  stockMapper.toModel(control);

        productRepository.findById(control.productId())
            .orElseThrow(() -> new BadRequestException(
                String.format("product id '%d' unregistred", control.productId())));
        
        if(control.type().equals(StockType.ENTRY))
            return stockRepository.save(stockControlModel);

        var totalProductInStock = stockRepository.getTotalAmounts(control.productId());

        if(totalProductInStock == null) 
            throw new BusinessException(
                String.format("no records of product id '%d' in stock", control.productId()));

        if(totalProductInStock >= stockControlModel.getAmount())               
            return stockRepository.save(stockControlModel);

        throw new BusinessException("product insufficient amount in stock");
    }

    public List<Stock> listAll() {
        return stockRepository.findAll();
    }

}
