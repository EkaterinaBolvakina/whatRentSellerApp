package group40.whatrentsellerapp.dto.categoryDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryAllParamDto {
    @NotNull(message = "Category ID must be not null")
    private Long categoryId;

    @NotBlank(message = "Category name must be not blank")
    @Size(min = 3, max = 35, message = "Category name must contain between 3 and 25 characters")
    private String categoryName;
}
