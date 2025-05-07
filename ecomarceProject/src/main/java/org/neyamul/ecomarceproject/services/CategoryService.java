package org.neyamul.ecomarceproject.services;

import org.neyamul.ecomarceproject.model.Category;
import org.neyamul.ecomarceproject.payload.CategoryDTO;
import org.neyamul.ecomarceproject.payload.CategoryResponse;

import java.util.List;


public interface CategoryService {

   CategoryResponse findAll();

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    String deleteCateroy(long categoryId);


    Category updateCategory(Category category, long categoryId);
}
