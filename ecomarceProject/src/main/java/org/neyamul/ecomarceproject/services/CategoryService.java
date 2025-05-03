package org.neyamul.ecomarceproject.services;

import org.neyamul.ecomarceproject.model.Category;

import java.util.List;


public interface CategoryService {

    List<Category> findAll();

    void createCateroy(Category category);

    String deleteCateroy(long categoryId);


    Category updateCategory(Category category, long categoryId);
}
