package group40.whatrentsellerapp.service.interfaces.sellerServiceInterface;

import group40.whatrentsellerapp.dto.sellerDto.SellerCreateResponseDto;
import org.springframework.http.ResponseEntity;

public interface IUpdateSellerService {
    ResponseEntity<SellerCreateResponseDto> updateSellerPasswordByEmail(String newPassword, String email);
    ResponseEntity<SellerCreateResponseDto> updateSellerNameByEmail(String newSellerName, String email);
}
