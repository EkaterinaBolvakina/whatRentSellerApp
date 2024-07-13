package group40.whatrentsellerapp.service.productService;

import group40.whatrentsellerapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentsellerapp.repository.IProductRepository;
import group40.whatrentsellerapp.service.interfaces.productServiceInterface.IDeleteProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService implements IDeleteProductService {
    private final IProductRepository productRepository;

    public DeleteProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<Void> deleteProductById(Long productId) {

        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new NotFoundException("Product with id = " + productId + " not found");
        }
    }
}
