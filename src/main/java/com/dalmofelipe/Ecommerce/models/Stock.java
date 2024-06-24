package com.dalmofelipe.Ecommerce.models;

import com.dalmofelipe.Ecommerce.models.enums.StockType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TB_STOCKS")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer amount;

    @Enumerated(EnumType.STRING)
    private StockType type;

    @Column(name = "registred_at")
    private LocalDate registredAt;

    @Column(name = "valid_until")
    private LocalDate validUntil;

    {
        registredAt = LocalDate.now();
        validUntil = null;
    }

    public Stock() {  }

    public Stock(Integer id, Product product, Integer amount, StockType type, LocalDate registredAt, LocalDate validUntil) {
        this.id = id;
        this.product = product;
        this.amount = amount;
        this.type = type;
        this.registredAt = registredAt;
        this.validUntil = validUntil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public StockType getType() {
        return type;
    }

    public void setType(StockType type) {
        this.type = type;
    }

    public LocalDate getRegistredAt() {
        return registredAt;
    }

    public void setRegistredAt(LocalDate registredAt) {
        this.registredAt = registredAt;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Stock stock = (Stock) o;
        return Objects.equals(id, stock.id) && Objects.equals(product, stock.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", amount=" + amount +
                ", product=" + product +
                ", type=" + type +
                '}';
    }
}
