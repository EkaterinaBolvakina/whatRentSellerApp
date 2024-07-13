package group40.whatrentsellerapp.service.interfaces.sellerServiceInterface;


import group40.whatrentsellerapp.dto.categoryDto.CategoryAllParamDto;
import group40.whatrentsellerapp.dto.categoryDto.CategoryResponseDto;
import group40.whatrentsellerapp.dto.sellerDto.SellerResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFindSellerService {
    ResponseEntity<List<SellerResponseDto>> findAll();

    ResponseEntity<SellerResponseDto> findById(Long id);

    ResponseEntity<SellerResponseDto> findBySellerName(String sellerName);

    ResponseEntity<SellerResponseDto> findBySellerEmail(String sellerEmail);

}
