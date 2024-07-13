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
public class CategoryRequestDto {

    @NotBlank(message = "Category name must be not blank")
    @NotNull(message = "Category name must be not null")
    @Size(min = 3, max = 35, message = "Category name must contain between 3 and 25 characters")
    private String categoryName;
}
