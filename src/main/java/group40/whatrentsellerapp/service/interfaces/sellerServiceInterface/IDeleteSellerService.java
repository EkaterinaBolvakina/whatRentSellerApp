package group40.whatrentsellerapp.service.interfaces.sellerServiceInterface;

import org.springframework.http.ResponseEntity;

public interface IDeleteSellerService {
    ResponseEntity<Void> deleteSellerByEmail(String sellerEmail);
}
