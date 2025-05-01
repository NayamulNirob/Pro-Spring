package org.neyamul.ecomarceproject.services;

import org.neyamul.ecomarceproject.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    private List<Category> categories =new ArrayList<>();

    @Override
    public List<Category> findAll() {
        return categories;
    }

    @Override
    public void createCateroy(Category category) {
        categories.add(category);
    }
}
