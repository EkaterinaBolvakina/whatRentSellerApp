package group40.whatrentsellerapp.service.sellerService;

import group40.whatrentsellerapp.domain.Seller;
import group40.whatrentsellerapp.dto.sellerDto.SellerResponseDto;
import group40.whatrentsellerapp.exception_handling.exceptions.IsEmptyException;
import group40.whatrentsellerapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentsellerapp.repository.ISellerRepository;
import group40.whatrentsellerapp.service.interfaces.sellerServiceInterface.IFindSellerService;
import group40.whatrentsellerapp.service.mapping.SellerConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindSellerService implements IFindSellerService {
    private final ISellerRepository sellerRepository;
    private final SellerConverter sellerConverter;

    @Override
    public ResponseEntity<List<SellerResponseDto>> findAll() {
        List<Seller> allSellers = sellerRepository.findAll();
        List<SellerResponseDto> allSellersDto = allSellers.stream()
                .map(sellerConverter::convertToDto)
                .toList();
        if (!allSellers.isEmpty()) {
            return new ResponseEntity<>(allSellersDto, HttpStatus.OK);
        } else {
            throw new IsEmptyException("No seller exists");
        }
    }

    @Override
    public ResponseEntity<SellerResponseDto> findById(Long id) {
        Optional<Seller> foundedSellerOptional = sellerRepository.findBySellerId(id);

        if (foundedSellerOptional.isPresent()) {
            SellerResponseDto foundedSellerDto = sellerConverter.convertToDto(foundedSellerOptional.get());
            return new ResponseEntity<>(foundedSellerDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("Seller with id = " + id + " not found");
        }
    }

    @Override
    public ResponseEntity<SellerResponseDto> findBySellerName(String sellerName) {
        Optional<Seller> foundedSellerOptional = sellerRepository.findBySellerName(sellerName);

        if (foundedSellerOptional.isPresent()) {
            SellerResponseDto foundedSellerDto = sellerConverter.convertToDto(foundedSellerOptional.get());
            return new ResponseEntity<>(foundedSellerDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("Seller with name '" + sellerName + "' not found");
        }
    }

    @Override
    public ResponseEntity<SellerResponseDto> findBySellerEmail(String sellerEmail) {
        Optional<Seller> foundedSellerOptional = sellerRepository.findBySellerEmail(sellerEmail);

        if (foundedSellerOptional.isPresent()) {
            SellerResponseDto foundedSellerDto = sellerConverter.convertToDto(foundedSellerOptional.get());
            return new ResponseEntity<>(foundedSellerDto, HttpStatus.OK);
        } else {
            throw new NotFoundException("Seller with email '" + sellerEmail + "' not found");
        }
    }

    @Override
    public Seller findSellerByIdForCreateProduct(Long id) {
        Optional<Seller> foundedSellerOptional = sellerRepository.findBySellerId(id);

        if (foundedSellerOptional.isPresent()) {
            return foundedSellerOptional.get();
        } else {
            throw new NotFoundException("Seller with id = " + id + " not found");
        }
    }

    @Override
    public Seller findSellerByNameForCreateProduct(String sellerName) {
        Optional<Seller> foundedSellerOptional = sellerRepository.findBySellerName(sellerName);

        if (foundedSellerOptional.isPresent()) {
            return foundedSellerOptional.get();
        } else {
            throw new NotFoundException("Seller with name '" + sellerName + "' not found");
        }
    }
}
