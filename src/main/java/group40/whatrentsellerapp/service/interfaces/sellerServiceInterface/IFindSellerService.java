package group40.whatrentsellerapp.service.interfaces.sellerServiceInterface;


import group40.whatrentsellerapp.domain.Seller;
import group40.whatrentsellerapp.dto.sellerDto.SellerResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFindSellerService {
    ResponseEntity<List<SellerResponseDto>> findAll();

    ResponseEntity<SellerResponseDto> findById(Long id);

    ResponseEntity<SellerResponseDto> findBySellerName(String sellerName);

    ResponseEntity<SellerResponseDto> findBySellerEmail(String sellerEmail);

    Seller findSellerByIdForCreateProduct(Long id);
    Seller findSellerByNameForCreateProduct(String sellerName);

}
