package group40.whatrentsellerapp.service.interfaces.categoryServiceInterface;


import group40.whatrentsellerapp.domain.Category;
import group40.whatrentsellerapp.dto.categoryDto.CategoryResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFindCategoryService {
    ResponseEntity<List<CategoryResponseDto>> findAll();
    ResponseEntity<CategoryResponseDto> findById(Long id);
    ResponseEntity<CategoryResponseDto> findByName(String categoryName);
    Category findCategoryByIdForCreateProduct(Long id);
    Category findCategoryByNameForCreateProduct(String categoryName);
}
