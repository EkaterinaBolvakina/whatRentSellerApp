package group40.whatrentsellerapp.dto.productDto;

import group40.whatrentsellerapp.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private Long productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productQuantity;
    private Boolean isOnStock;
    private Category productCategory;
    private Long sellerId;
    private String sellerBusinessName;
}
