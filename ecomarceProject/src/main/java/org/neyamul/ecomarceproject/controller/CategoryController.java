package org.neyamul.ecomarceproject.controller;

import org.neyamul.ecomarceproject.model.Category;
import org.neyamul.ecomarceproject.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    
    @GetMapping("public/categories")
    public List<Category> getCategories() {
        return categoryService.findAll();
    }

    @PostMapping("public/categories/save")
    public String createCategory(@RequestBody Category category) {
        categoryService.createCateroy(category);
        return "Category added successfully";
    }




}
