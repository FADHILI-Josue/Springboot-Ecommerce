package com.fadhili.Ecommerce.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fadhili.Ecommerce.exceptions.NotFoundException;
import com.fadhili.Ecommerce.models.Category;
import com.fadhili.Ecommerce.models.Product;
import com.fadhili.Ecommerce.records.ProductInput;
import com.fadhili.Ecommerce.repositories.CategoryRepository;

@Service
public class ProductMapper {

    @Autowired
    private CategoryRepository categoryRepository;

    public void toUpdate(Product present, ProductInput updateData) {
        present.setName(updateData.name().isEmpty() ? present.getName() : updateData.name());
        present.setBrand(updateData.brand().isEmpty() ? present.getBrand() : updateData.brand());
        present.setDetails(updateData.details().isEmpty() ? present.getDetails() : updateData.details());
        present.setPrice(updateData.price() == null ? present.getPrice() : updateData.price());

        Category category = categoryRepository.findById(updateData.categoryId())
            .orElseThrow(() -> new NotFoundException("category id '"+updateData.categoryId()+"'not found"));

        present.setCategory((category == null) ? present.getCategory() : category);
    }

}
