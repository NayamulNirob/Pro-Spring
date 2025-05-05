package org.neyamul.ecomarceproject.services;

import org.neyamul.ecomarceproject.model.Category;
import org.neyamul.ecomarceproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

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

        List<Category> categories = categoryRepository.findAll();

      Category category=  categories.stream().filter
                        (c -> c.getCategoryId().equals(categoryId))
                .findFirst().orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found with id "+categoryId)
              );
            categoryRepository.delete(category);
            return "Category with categoryId " + categoryId + " deleted successfully !!";


    }

    @Override
    public Category updateCategory(Category category, long categoryId) {
        List<Category> categories = categoryRepository.findAll();

        Optional<Category> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();
        if (optionalCategory.isPresent()) {
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            Category savedCategory= categoryRepository.save(existingCategory);
            return  savedCategory;
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found with id "+categoryId);
        }

    }


}
