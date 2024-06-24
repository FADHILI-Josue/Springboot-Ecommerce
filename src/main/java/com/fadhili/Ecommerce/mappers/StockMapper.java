package com.fadhili.Ecommerce.mappers;

import com.fadhili.Ecommerce.models.Stock;
import com.fadhili.Ecommerce.records.StockControl;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@DecoratedWith(StockMapperDecorator.class)
public interface StockMapper {

    public Stock toModel(StockControl mapper);

}
