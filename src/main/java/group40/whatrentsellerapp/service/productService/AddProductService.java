package group40.whatrentsellerapp.service.productService;

import group40.whatrentsellerapp.domain.Product;
import group40.whatrentsellerapp.dto.productDto.ProductRequestDto;
import group40.whatrentsellerapp.dto.productDto.ProductResponseDto;
import group40.whatrentsellerapp.repository.IProductRepository;
import group40.whatrentsellerapp.service.interfaces.productServiceInterface.IAddProductService;
import group40.whatrentsellerapp.service.mapping.ProductConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AddProductService implements IAddProductService {
    private final IProductRepository productRepository;
    private final ProductConverter productConverter;

    @Override
    public ResponseEntity<ProductResponseDto> addProduct(ProductRequestDto productRequestDto) {

        Product newProduct = productConverter.convertFromDto(productRequestDto);

        Product savedNewProduct = productRepository.save(newProduct);
        ProductResponseDto dto = productConverter.convertToDto(savedNewProduct);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
