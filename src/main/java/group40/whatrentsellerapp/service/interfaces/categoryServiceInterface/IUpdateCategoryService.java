package group40.whatrentsellerapp.service.interfaces.categoryServiceInterface;


import group40.whatrentsellerapp.dto.categoryDto.CategoryResponseDto;
import org.springframework.http.ResponseEntity;

public interface IUpdateCategoryService {
    ResponseEntity<CategoryResponseDto> updateCategoryNameById(Long id, String name);
}
