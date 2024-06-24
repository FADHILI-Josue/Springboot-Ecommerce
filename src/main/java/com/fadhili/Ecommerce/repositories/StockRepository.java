package com.fadhili.Ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fadhili.Ecommerce.models.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    
    Optional<Stock> findByProductId(Integer id);

    @Query("SELECT SUM(CASE WHEN s.type = 'ENTRY' THEN s.amount ELSE s.amount * -1 END) \n" +
        "FROM Stock s WHERE s.product = (SELECT p FROM Product p WHERE p.id = :productId)")
    Integer getTotalAmounts(Integer productId);

}
