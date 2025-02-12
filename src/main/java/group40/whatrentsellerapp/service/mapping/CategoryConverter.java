package group40.whatrentsellerapp.service.mapping;

import group40.whatrentsellerapp.domain.Category;
import group40.whatrentsellerapp.dto.categoryDto.CategoryRequestDto;
import group40.whatrentsellerapp.dto.categoryDto.CategoryResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CategoryConverter {
    public Category convertFromDto(CategoryRequestDto dto) {
        Category category = new Category();

        if (dto.getCategoryName() != null) {
            category.setCategoryName(dto.getCategoryName());
        }

        return category;
    }

    public CategoryResponseDto convertToDto(Category category) {
        CategoryResponseDto dto = new CategoryResponseDto();

        dto.setCategoryId(category.getId());

        if (category.getCategoryName() != null) {
            dto.setCategoryName(category.getCategoryName());
        }

        return dto;
    }
}
