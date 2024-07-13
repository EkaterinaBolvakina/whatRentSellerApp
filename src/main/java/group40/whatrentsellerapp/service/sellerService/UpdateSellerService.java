package group40.whatrentsellerapp.service.sellerService;

import group40.whatrentsellerapp.domain.Seller;
import group40.whatrentsellerapp.dto.sellerDto.SellerCreateResponseDto;
import group40.whatrentsellerapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentsellerapp.repository.ISellerRepository;
import group40.whatrentsellerapp.service.interfaces.sellerServiceInterface.IUpdateSellerService;
import group40.whatrentsellerapp.service.mapping.SellerConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateSellerService implements IUpdateSellerService {
    private final ISellerRepository sellerRepository;
    private final SellerConverter sellerConverter;

    @Override
    public ResponseEntity<SellerCreateResponseDto> updateSellerPasswordByEmail(String newPassword, String email) {

        if (sellerRepository.findByEmail(email).isPresent()) {
            sellerRepository.updateSellerPasswordByEmail(newPassword, email);
            Seller updatedSeller = sellerRepository.findByEmail(email).get();
            SellerCreateResponseDto dto = sellerConverter.convertToCreateDto(updatedSeller);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            throw new NotFoundException("Seller with email = " + email + " not found");
        }
    }

    @Override
    public ResponseEntity<SellerCreateResponseDto> updateSellerNameByEmail(String newSellerName, String email) {
        if (sellerRepository.findByEmail(email).isPresent()) {
            sellerRepository.updateSellerNameByEmail(newSellerName, email);
            Seller updatedSeller = sellerRepository.findByEmail(email).get();
            SellerCreateResponseDto dto = sellerConverter.convertToCreateDto(updatedSeller);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            throw new NotFoundException("Seller with email = " + email + " not found");
        }
    }
}
