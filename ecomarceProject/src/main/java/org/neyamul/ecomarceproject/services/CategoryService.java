package org.neyamul.ecomarceproject.services;

import org.neyamul.ecomarceproject.model.Category;
import org.neyamul.ecomarceproject.payload.CategoryDTO;
import org.neyamul.ecomarceproject.payload.CategoryResponse;

import java.util.List;


public interface CategoryService {

   CategoryResponse findAll(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCateroy(Long categoryId);


    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
