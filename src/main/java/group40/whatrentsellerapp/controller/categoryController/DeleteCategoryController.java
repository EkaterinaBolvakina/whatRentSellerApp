package group40.whatrentsellerapp.controller.categoryController;

import group40.whatrentsellerapp.service.categoryService.DeleteCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class DeleteCategoryController {
    private final DeleteCategoryService deleteCategoryService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) {
        return deleteCategoryService.deleteCategoryById(id);
    }
}
