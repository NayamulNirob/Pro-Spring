package org.neyamul.ecomarceproject.services;

import org.modelmapper.ModelMapper;
import org.neyamul.ecomarceproject.exceptions.APIException;
import org.neyamul.ecomarceproject.exceptions.ResourceNoTFoundException;
import org.neyamul.ecomarceproject.model.Category;
import org.neyamul.ecomarceproject.payload.CategoryDTO;
import org.neyamul.ecomarceproject.payload.CategoryResponse;
import org.neyamul.ecomarceproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse findAll() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new ResourceNoTFoundException("Category List is Empty");
        }
        List<CategoryDTO> categoryDTOList = categories.stream().map(
                category -> modelMapper.map(category, CategoryDTO.class)).toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOList);

        return categoryResponse;
    }


    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategory != null) {
            throw new APIException("Category With This Name : '" + category.getCategoryName() + "' Already Exist");
        }
         Category newCategory= categoryRepository.save(category);
        return modelMapper.map(newCategory, CategoryDTO.class);

    }

    @Override
    public String deleteCateroy(long categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNoTFoundException("Category", "categoryId", categoryId));
        categoryRepository.delete(category);
        return "Category With CategoryId: " + categoryId + " deleted Successfully";

    }

    @Override
    public Category updateCategory(Category category, long categoryId) {

        Category savedCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNoTFoundException("Category", "categoryId", categoryId));
        category.setCategoryId(categoryId);
        categoryRepository.save(category);
        return savedCategory;

    }


}
