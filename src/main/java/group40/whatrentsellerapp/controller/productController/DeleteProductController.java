package group40.whatrentsellerapp.controller.productController;

import group40.whatrentsellerapp.service.interfaces.productServiceInterface.IDeleteProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class DeleteProductController {
    private final IDeleteProductService deleteProductService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        return deleteProductService.deleteProductById(id);
    }
}
