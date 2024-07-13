package group40.whatrentsellerapp.service.interfaces.categoryServiceInterface;

import org.springframework.http.ResponseEntity;

public interface IDeleteCategoryService {
    ResponseEntity<Void> deleteCategoryById(Long categoryId);
}
