package group40.whatrentsellerapp.controller.productController;


import group40.whatrentsellerapp.dto.productDto.ProductRequestDto;
import group40.whatrentsellerapp.dto.productDto.ProductResponseDto;
import group40.whatrentsellerapp.service.productService.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class AddProductController {

    private final AddProductService addProductService;

    @Autowired
    public AddProductController(AddProductService addProductService) {
        this.addProductService = addProductService;
    }

    @PostMapping("/addNew")
    public ResponseEntity<ProductResponseDto> addProduct(@RequestBody ProductRequestDto productRequestDto) {
        return addProductService.addProduct(productRequestDto);
    }
}
