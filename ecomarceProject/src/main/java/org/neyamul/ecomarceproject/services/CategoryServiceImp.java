package org.neyamul.ecomarceproject.services;

import org.neyamul.ecomarceproject.model.Category;
import org.neyamul.ecomarceproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private  CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCateroy(Category category) {
            categoryRepository.save(category);

    }

    @Override
    public String deleteCateroy(long categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found with id "+categoryId)
        );
        categoryRepository.delete(category);
        return "Category With CategoryId: "+categoryId+ " deleted Successfully";

    }

    @Override
    public Category updateCategory(Category category, long categoryId) {

        Category savedCategory = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found with id "+categoryId)
        );
        category.setCategoryId(categoryId);
        categoryRepository.save(category);
        return savedCategory;

    }


}
