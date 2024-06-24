package com.dalmofelipe.Ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TB_CATEGORIES")
public class Category {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_root_id")
    private Category categoryRoot;

    @JsonProperty("categoryRoot")
    public String getCategoryRootName() {
        return this.categoryRoot != null ? this.categoryRoot.getName() : null;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "categoryRoot", fetch = FetchType.LAZY)
    private List<Category> subCategories;

    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category() {}

    public Category(Integer id, String name, Category categoryRoot, List<Category> subCategories, List<Product> products) {
        this.id = id;
        this.name = name;
        this.categoryRoot = categoryRoot;
        this.subCategories = subCategories;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategoryRoot() {
        return categoryRoot;
    }

    public void setCategoryRoot(Category categoryRoot) {
        this.categoryRoot = categoryRoot;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Category category = (Category) o;
        return Objects.equals(id, category.id) && Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
