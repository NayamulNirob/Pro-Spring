package org.neyamul.ecomarceproject.services;

import org.neyamul.ecomarceproject.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {

    List<Category> findAll();

    void createCateroy(Category category);

}
