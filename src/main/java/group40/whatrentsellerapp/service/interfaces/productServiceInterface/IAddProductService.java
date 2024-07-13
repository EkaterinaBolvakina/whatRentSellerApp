package group40.whatrentsellerapp.service.interfaces.productServiceInterface;

import group40.whatrentsellerapp.dto.productDto.ProductRequestDto;
import group40.whatrentsellerapp.dto.productDto.ProductResponseDto;
import org.springframework.http.ResponseEntity;

public interface IAddProductService {
    ResponseEntity<ProductResponseDto> addProduct(ProductRequestDto productRequestDto);
}
