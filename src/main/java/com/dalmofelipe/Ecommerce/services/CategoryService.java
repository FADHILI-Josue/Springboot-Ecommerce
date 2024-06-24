package com.dalmofelipe.Ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dalmofelipe.Ecommerce.exceptions.AlreadyExistsException;
import com.dalmofelipe.Ecommerce.exceptions.NotFoundException;
import com.dalmofelipe.Ecommerce.models.Category;
import com.dalmofelipe.Ecommerce.records.CategoryInput;
import com.dalmofelipe.Ecommerce.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category create(CategoryInput categoryInput) {
        Optional<Category> categoryOpt = categoryRepository.findByName(categoryInput.name());

        if (categoryOpt.isPresent()) throw new AlreadyExistsException("category already exist");
        
        return categoryRepository.save(categoryInput.toModel());
    }

    public Category getById(Integer categoryId) {
        Optional<Category> categoryOpt = categoryRepository.findById(categoryId);

        if(categoryOpt.isEmpty()) throw new NotFoundException("category not found");

        return categoryOpt.get();
    }

    public List<Category> listAll() {
        return categoryRepository.findAll();
    }

    public void deleteById(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

}
