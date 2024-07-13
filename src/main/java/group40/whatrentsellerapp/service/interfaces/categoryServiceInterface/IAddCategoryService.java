package group40.whatrentsellerapp.service.interfaces.categoryServiceInterface;


import group40.whatrentsellerapp.dto.categoryDto.CategoryRequestDto;
import group40.whatrentsellerapp.dto.categoryDto.CategoryResponseDto;
import org.springframework.http.ResponseEntity;

public interface IAddCategoryService {
    ResponseEntity<CategoryResponseDto> addCategory(CategoryRequestDto requestDto);
}
