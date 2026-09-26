package com.ecommerce.backend.service;

import com.ecommerce.backend.model.Category;
import com.ecommerce.backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getMacroCategories() {
        return categoryRepository.findByParentCategoryIsNullOrderBySortOrderAsc();
    }

    public List<Category> getSubCategories(UUID parentId) {
        return categoryRepository.findByParentCategory_Id(parentId);

    }
}