package group40.whatrentsellerapp.service.categoryService;



import group40.whatrentsellerapp.domain.Category;
import group40.whatrentsellerapp.dto.categoryDto.CategoryRequestDto;
import group40.whatrentsellerapp.dto.categoryDto.CategoryResponseDto;
import group40.whatrentsellerapp.exception_handling.exceptions.AlreadyExistException;
import group40.whatrentsellerapp.repository.ICategoryRepository;
import group40.whatrentsellerapp.service.interfaces.categoryServiceInterface.IAddCategoryService;
import group40.whatrentsellerapp.service.mapping.CategoryConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddCategoryService implements IAddCategoryService {

    private final ICategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    @Override
    public ResponseEntity<CategoryResponseDto> addCategory(CategoryRequestDto requestDto) {

        if (categoryRepository.findByCategoryName(requestDto.getCategoryName()).isEmpty()) {

            Category newCategory = categoryConverter.convertFromDto(requestDto);
            Category savedNewCategory = categoryRepository.save(newCategory);
            CategoryResponseDto dto = categoryConverter.convertToDto(savedNewCategory);
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        } else {
            throw new AlreadyExistException("Category already exists");
        }
    }
}
