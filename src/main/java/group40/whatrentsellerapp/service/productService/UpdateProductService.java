package group40.whatrentsellerapp.service.productService;

import group40.whatrentsellerapp.domain.Product;
import group40.whatrentsellerapp.dto.productDto.ProductRequestDto;
import group40.whatrentsellerapp.dto.productDto.ProductResponseDto;
import group40.whatrentsellerapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentsellerapp.repository.IProductRepository;
import group40.whatrentsellerapp.service.interfaces.categoryServiceInterface.IFindCategoryService;
import group40.whatrentsellerapp.service.interfaces.productServiceInterface.IUpdateProductService;
import group40.whatrentsellerapp.service.interfaces.sellerServiceInterface.IFindSellerService;
import group40.whatrentsellerapp.service.mapping.ProductConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UpdateProductService implements IUpdateProductService {
    private final IProductRepository productRepository;
    private final ProductConverter productConverter;
    private final IFindCategoryService findCategoryService;
    private final IFindSellerService findSellerService;

    @Override
    public ResponseEntity<ProductResponseDto> updateProduct(Long productId, ProductRequestDto productRequestDto) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product productForUpdate = productOptional.get();

            if (productRequestDto.getProductName() != null) {
                productForUpdate.setName(productRequestDto.getProductName());
            }
            if (productRequestDto.getProductDescription() != null) {
                productForUpdate.setDescription(productRequestDto.getProductDescription());
            }
            if (productRequestDto.getProductPrice() != null) {
                productForUpdate.setPrice(productRequestDto.getProductPrice());
            }
            if (productRequestDto.getProductQuantity() != null) {
                productForUpdate.setQuantity(productRequestDto.getProductQuantity());
            }
            if (productRequestDto.getIsOnStock() != null) {
                productForUpdate.setIsOnStock(productRequestDto.getIsOnStock());
            }
            if (productRequestDto.getProductCategoryId() != null) {
                productForUpdate.setCategory(findCategoryService.findCategoryByIdForCreateProduct(productRequestDto.getProductCategoryId()));
            }
            if (productRequestDto.getSellerId() !=null) {
                productForUpdate.setSeller(findSellerService.findSellerByIdForCreateProduct(productRequestDto.getSellerId()));
            }

            Product updatedProduct = productRepository.save(productForUpdate);
            ProductResponseDto productResponseDto = productConverter.convertToDto(updatedProduct);
            return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("Product with id = " + productId + " not found");
        }
    }
}
