package group40.whatrentsellerapp.dto.productDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    @NotBlank(message = "Product name must be not blank")
    @Size(min=3, max=25, message = "Product name length must be between 3 and 25 characters")
    private String productName;

    @NotBlank(message = "Product description must be not blank")
    @Size(min=3, max=45, message = "Product description length must be between 3 and 45 characters")
    private String productDescription;

    @NotNull(message = "Product price must be not null")
    private Double productPrice;

    @NotNull(message = "Product quantity must be not null")
    private Integer productQuantity;

    @NotNull(message = "Product onStock must be not null")
    private Boolean isOnStock;

    @NotNull
    private Long productCategoryId;
    @NotNull
    private Long sellerId;

}
