package com.ecommerce.backend.controller;

import com.ecommerce.backend.service.CategoryService;
import dto.CategoryDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/macro")
    public List<CategoryDTO> getMacroCategories() {
        return categoryService.getMacroCategories()
                .stream()
                .map(cat -> new CategoryDTO(cat.getId(), cat.getName(), cat.getSlug(), cat.getImageUrl()))
                .collect(Collectors.toList());
    }

    @GetMapping("/sub")
    public List<CategoryDTO> getSubCategories(@RequestParam("parentId") UUID parentId) {
        return categoryService.getSubCategories(parentId) // À lier à repository.findByParentCategory_Id(parentId)
                .stream()
                .map(cat -> new CategoryDTO(cat.getId(), cat.getName(), cat.getSlug(), cat.getImageUrl()))
                .collect(Collectors.toList());
    }
}