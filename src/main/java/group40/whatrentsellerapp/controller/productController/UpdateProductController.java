package group40.whatrentsellerapp.controller.productController;

import group40.whatrentsellerapp.dto.productDto.ProductRequestDto;
import group40.whatrentsellerapp.dto.productDto.ProductResponseDto;
import group40.whatrentsellerapp.service.productService.UpdateProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class UpdateProductController {
    private final UpdateProductService updateProductService;

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDto productRequestDto) {
        return updateProductService.updateProduct(id, productRequestDto);
    }
}
