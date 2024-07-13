package group40.whatrentsellerapp.service.categoryService;

import group40.whatrentsellerapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentsellerapp.repository.ICategoryRepository;
import group40.whatrentsellerapp.service.interfaces.categoryServiceInterface.IDeleteCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryService implements IDeleteCategoryService {
    private final ICategoryRepository categoryRepository;

    public DeleteCategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public ResponseEntity<Void> deleteCategoryById(Long categoryId) {

        if (categoryRepository.existsById(categoryId)) {
            categoryRepository.deleteById(categoryId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new NotFoundException("Category with id = " + categoryId + " not found");
        }
    }
}
