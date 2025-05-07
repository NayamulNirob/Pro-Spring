package org.neyamul.ecomarceproject.restcontroller;

import jakarta.validation.Valid;
import org.neyamul.ecomarceproject.model.Category;
import org.neyamul.ecomarceproject.payload.CategoryDTO;
import org.neyamul.ecomarceproject.payload.CategoryResponse;
import org.neyamul.ecomarceproject.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class CategoryRestController {


    @Autowired
    private CategoryService categoryService;


    //@GetMapping("public/categories")
    @RequestMapping(value = "public/categories", method = RequestMethod.GET)
    public ResponseEntity<CategoryResponse> getCategories() {
        CategoryResponse categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("public/categories/save")
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
       CategoryDTO savedCategoryDTO= categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("categories/admin/delete/{categoryId}")
    public ResponseEntity<String> deleteCetegory(@PathVariable long categoryId) {
            categoryService.deleteCateroy(categoryId);
            return new ResponseEntity<>("Category Deleted Successfully",HttpStatus.OK);
    }

    @PutMapping("categories/admin/update/{categoryId}")
    public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category, @PathVariable long categoryId) {
            categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Category Updated Successfully",HttpStatus.OK);

    }


}
