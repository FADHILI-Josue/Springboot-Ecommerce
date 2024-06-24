package com.fadhili.Ecommerce.records;

import org.springframework.beans.BeanUtils;

import com.fadhili.Ecommerce.models.Category;

public record CategoryInput(
    String name, 
    Integer categoryRootId
) {

    public Category toModel() {
        Category category = new Category();
        BeanUtils.copyProperties(this, category);
        return category;
    }

}
