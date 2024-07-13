package group40.whatrentsellerapp.service.categoryService;

import group40.whatrentsellerapp.domain.Category;
import group40.whatrentsellerapp.dto.categoryDto.CategoryAllParamDto;
import group40.whatrentsellerapp.dto.categoryDto.CategoryResponseDto;
import group40.whatrentsellerapp.exception_handling.exceptions.IsEmptyException;
import group40.whatrentsellerapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentsellerapp.repository.ICategoryRepository;
import group40.whatrentsellerapp.service.interfaces.categoryServiceInterface.IFindCategoryService;
import group40.whatrentsellerapp.service.mapping.CategoryConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FindCategoryService implements IFindCategoryService {
    private final ICategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    @Override
    public ResponseEntity<List<CategoryResponseDto>> findAll() {
        List<Category> allCategories = categoryRepository.findAll();
        List<CategoryResponseDto> allCategoriesDto = allCategories.stream()
                .map(categoryConverter::convertToDto)
                .toList();
        if (!allCategories.isEmpty()) {
            return new ResponseEntity<>(allCategoriesDto, HttpStatus.OK);
        } else {
            throw new IsEmptyException("No category exists");
        }
    }

    @Override
    public ResponseEntity<CategoryResponseDto> findById(Long id) {
        Optional<Category> foundedCategoryOptional = categoryRepository.findById(id);

        if (foundedCategoryOptional.isPresent()) {
            CategoryResponseDto foundedCategoryDto = categoryConverter.convertToDto(foundedCategoryOptional.get());
            return new ResponseEntity<>(foundedCategoryDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("Category with id = " + id + " not found");
        }
    }

    @Override
    public ResponseEntity<CategoryResponseDto> findByName(String categoryName) {
        Optional<Category> foundedCategoryOptional = categoryRepository.findByCategoryName(categoryName);

        if (foundedCategoryOptional.isPresent()) {
            CategoryResponseDto foundedCategoryDto = categoryConverter.convertToDto(foundedCategoryOptional.get());
            return new ResponseEntity<>(foundedCategoryDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("Category with name '" + categoryName + "' not found");
        }
    }

    @Override
    public ResponseEntity<CategoryAllParamDto> findAllParamById(Long id) {
        Optional<Category> foundedCategoryOptional = categoryRepository.findById(id);

        if (foundedCategoryOptional.isPresent()) {
            CategoryAllParamDto foundedCategoryDto = categoryConverter.convertToDtoWithAllParam(foundedCategoryOptional.get());
            return new ResponseEntity<>(foundedCategoryDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("Category with id = " + id + " not found");
        }
    }
}
