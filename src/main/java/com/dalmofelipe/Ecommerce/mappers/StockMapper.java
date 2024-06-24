package com.dalmofelipe.Ecommerce.mappers;

import com.dalmofelipe.Ecommerce.models.Stock;
import com.dalmofelipe.Ecommerce.records.StockControl;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(StockMapperDecorator.class)
public interface StockMapper {

    public Stock toModel(StockControl mapper);

}
