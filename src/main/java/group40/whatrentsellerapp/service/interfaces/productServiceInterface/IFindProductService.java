package group40.whatrentsellerapp.service.interfaces.productServiceInterface;


import group40.whatrentsellerapp.dto.productDto.ProductResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFindProductService {
    ResponseEntity<List<ProductResponseDto>> findAll();
    ResponseEntity<List<ProductResponseDto>> findByCategory(String category);
    ResponseEntity<List<ProductResponseDto>> findBySeller(String sellerName);
    ResponseEntity<ProductResponseDto> findById(Long id);
    ResponseEntity<List<ProductResponseDto>> findByName(String productName);
    ResponseEntity<List<ProductResponseDto>> findByDescription(String productDescription);
    ResponseEntity<List<ProductResponseDto>> findByPrice(Double productPrice);
    ResponseEntity<List<ProductResponseDto>> findByQuantity(Integer productQuantity);
    ResponseEntity<List<ProductResponseDto>> findByPriceInterval(Double productPriceMin, Double productPriceMax);
    ResponseEntity<List<ProductResponseDto>> findByQuantityInterval(Integer productQuantityMin, Integer productQuantityMax);
}
