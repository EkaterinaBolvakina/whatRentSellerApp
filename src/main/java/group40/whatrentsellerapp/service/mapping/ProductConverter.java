package group40.whatrentsellerapp.service.mapping;

import group40.whatrentsellerapp.domain.Product;
import group40.whatrentsellerapp.dto.productDto.ProductRequestDto;
import group40.whatrentsellerapp.dto.productDto.ProductResponseDto;
import group40.whatrentsellerapp.service.interfaces.categoryServiceInterface.IFindCategoryService;
import group40.whatrentsellerapp.service.interfaces.sellerServiceInterface.IFindSellerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ProductConverter {

    private final IFindCategoryService findCategoryService;
    private final IFindSellerService findSellerService;

    public Product convertFromDto(ProductRequestDto dto) {
        Product product = new Product();

        if (dto.getProductName() != null) {
            product.setName(dto.getProductName());
        }
        if (dto.getProductDescription() != null) {
            product.setDescription(dto.getProductDescription());
        }

        if (dto.getProductPrice() != null) {
            product.setPrice(dto.getProductPrice());
        }

        if (dto.getProductQuantity() != null) {
            product.setQuantity(dto.getProductQuantity());
        }

        if (dto.getIsOnStock() != null) {
            product.setIsOnStock(dto.getIsOnStock());
        }
        if (dto.getSellerId() !=null) {
            product.setSeller(findSellerService.findSellerByIdForCreateProduct(dto.getSellerId()));
        }
        if (dto.getProductCategoryId() != null) {
            product.setCategory(findCategoryService.findCategoryByIdForCreateProduct(dto.getProductCategoryId()));
        }
        return product;
    }

    public ProductResponseDto convertToDto(Product product) {

        ProductResponseDto dto = new ProductResponseDto();
        dto.setProductId(product.getId());

        if (product.getName() != null) {
            dto.setProductName(product.getName());
        }
        if (product.getDescription() != null) {
            dto.setProductDescription(product.getDescription());
        }
        if (product.getPrice() != null) {
            dto.setProductPrice(product.getPrice());
        }
        if (product.getQuantity() != null) {
            dto.setProductQuantity(product.getQuantity());
        }
        if (product.getCategory() != null) {
            dto.setProductCategory(product.getCategory());
        }
        if (product.getIsOnStock() != null) {
            dto.setIsOnStock(product.getIsOnStock());
        }
        if (product.getSeller() != null && product.getSeller().getId() != null) {
            dto.setSellerId(product.getSeller().getId());
            dto.setSellerBusinessName(product.getSeller().getBusinessName());
        }
        return dto;
    }
}
