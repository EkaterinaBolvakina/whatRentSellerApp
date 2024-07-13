package group40.whatrentsellerapp.service.interfaces.productServiceInterface;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IDeleteProductService {

    ResponseEntity<Void> deleteProductById(Long productId);

}
