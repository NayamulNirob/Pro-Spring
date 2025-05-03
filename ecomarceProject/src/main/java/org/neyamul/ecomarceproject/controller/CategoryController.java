package org.neyamul.ecomarceproject.controller;

import org.neyamul.ecomarceproject.model.Category;
import org.neyamul.ecomarceproject.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


//    @GetMapping("public/categories")
    @RequestMapping(value = "public/categories",method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategories() {
        List<Category>categories= categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("public/categories/save")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        categoryService.createCateroy(category);
        return new ResponseEntity<>( "Category added successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("categories/admin/delete/{categoryId}")
    public ResponseEntity<String> deleteCetegory(@PathVariable long categoryId) {
        try {
            String Status = categoryService.deleteCateroy(categoryId);
             return new ResponseEntity<>(Status, HttpStatus.OK);
        }
        catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }

    }

    @PutMapping("categories/admin/update/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,@PathVariable long categoryId) {
        try {
            Category updateCategory = categoryService.updateCategory(category,categoryId);
            return new ResponseEntity<>("Category with category id: "+ categoryId+" Updated successfully! ", HttpStatus.OK);
        }
        catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }


}
