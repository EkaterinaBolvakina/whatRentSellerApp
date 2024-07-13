package group40.whatrentsellerapp.service.interfaces.sellerServiceInterface;

import group40.whatrentsellerapp.dto.sellerDto.SellerCreateRequestDto;
import group40.whatrentsellerapp.dto.sellerDto.SellerCreateResponseDto;
import org.springframework.http.ResponseEntity;

public interface IAddSellerService {
    ResponseEntity<SellerCreateResponseDto> addSeller(SellerCreateRequestDto sellerCreateRequestDto);
}
