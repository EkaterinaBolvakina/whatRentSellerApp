package group40.whatrentsellerapp.dto.productDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productQuantity;
    private Boolean isOnStock;
    private Long productCategoryId;
    private Long sellerId;

}
