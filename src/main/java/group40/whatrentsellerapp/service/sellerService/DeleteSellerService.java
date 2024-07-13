package group40.whatrentsellerapp.service.sellerService;

import group40.whatrentsellerapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentsellerapp.repository.ISellerRepository;
import group40.whatrentsellerapp.service.interfaces.sellerServiceInterface.IDeleteSellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteSellerService implements IDeleteSellerService {
    private final ISellerRepository sellerRepository;

    @Override
    public ResponseEntity<Void> deleteSellerByEmail(String sellerEmail) {

        if (sellerRepository.findByEmail(sellerEmail).isPresent()) {
            sellerRepository.delete(sellerRepository.findByEmail(sellerEmail).get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new NotFoundException("Seller with email = " + sellerEmail + " not found");
        }
    }
}
