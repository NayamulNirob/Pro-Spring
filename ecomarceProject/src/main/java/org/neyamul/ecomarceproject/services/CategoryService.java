package org.neyamul.ecomarceproject.services;

import org.neyamul.ecomarceproject.payload.CategoryDTO;
import org.neyamul.ecomarceproject.payload.CategoryResponse;


public interface CategoryService {

   CategoryResponse findAll(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);


    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
