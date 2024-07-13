package group40.whatrentsellerapp.service.sellerService;


import group40.whatrentsellerapp.domain.Role;
import group40.whatrentsellerapp.domain.Seller;
import group40.whatrentsellerapp.dto.sellerDto.SellerCreateRequestDto;
import group40.whatrentsellerapp.dto.sellerDto.SellerCreateResponseDto;
import group40.whatrentsellerapp.exception_handling.exceptions.AlreadyExistException;
import group40.whatrentsellerapp.exception_handling.exceptions.NotFoundException;
import group40.whatrentsellerapp.repository.IRoleRepository;
import group40.whatrentsellerapp.repository.ISellerRepository;
import group40.whatrentsellerapp.service.interfaces.sellerServiceInterface.IAddSellerService;
import group40.whatrentsellerapp.service.mapping.SellerConverter;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AddSellerService implements IAddSellerService {

    private final ISellerRepository sellerRepository;
    private final SellerConverter sellerConverter;
    private final IRoleRepository roleRepository;

    @Override
    public ResponseEntity<SellerCreateResponseDto> addSeller(SellerCreateRequestDto sellerCreateRequestDto) {
        if (sellerRepository.findByEmail(sellerCreateRequestDto.getEmail()).isEmpty()) {
            Seller newSeller = sellerConverter.convertFromCreateDto(sellerCreateRequestDto);
            Optional<Role> defaultRole = roleRepository.findByName("SELLER");

            if (defaultRole.isPresent()) {
                newSeller.setRole(defaultRole.get());
            } else {
                throw new NotFoundException("Role 'SELLER' not found!");
            }

            Seller savedSeller = sellerRepository.save(newSeller);
            SellerCreateResponseDto dto = sellerConverter.convertToCreateDto(savedSeller);
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        } else {
            throw new AlreadyExistException("Seller with email '" + sellerCreateRequestDto.getEmail() + "' already exists");
        }
    }
}
