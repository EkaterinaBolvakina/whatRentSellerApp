package group40.whatrentsellerapp.service.mapping;

import group40.whatrentsellerapp.domain.Seller;
import group40.whatrentsellerapp.dto.sellerDto.SellerCreateRequestDto;
import group40.whatrentsellerapp.dto.sellerDto.SellerCreateResponseDto;
import group40.whatrentsellerapp.dto.sellerDto.SellerRequestDto;
import group40.whatrentsellerapp.dto.sellerDto.SellerResponseDto;
import org.springframework.stereotype.Service;

@Service
public class SellerConverter {
    public Seller convertFromCreateDto(SellerCreateRequestDto dto) {
        Seller seller = new Seller();
        if (dto.getSellerName() != null) {
            seller.setSellerName(dto.getSellerName());
        }
        if (dto.getEmail() != null) {
            seller.setEmail(dto.getEmail());
        }
        if (dto.getPassword() != null) {
            seller.setPassword(dto.getPassword());
        }
        return seller;
    }
    public Seller convertFromDto(SellerRequestDto dto) {
        Seller seller = new Seller();
        if (dto.getSellerName() != null) {
            seller.setSellerName(dto.getSellerName());
        }
        if (dto.getEmail() != null) {
            seller.setEmail(dto.getEmail());
        }
        if (dto.getPassword() != null) {
            seller.setPassword(dto.getPassword());
        }
        if (dto.getBusinessName() != null) {
            seller.setBusinessName(dto.getBusinessName());
        }
        if (dto.getFirstName() != null) {
            seller.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            seller.setLastName(dto.getLastName());
        }
        return seller;
    }

    public SellerCreateResponseDto convertToCreateDto(Seller seller) {
        SellerCreateResponseDto dto = new SellerCreateResponseDto();

        dto.setId(seller.getId());
        dto.setSellerName(seller.getSellerName());
        dto.setRoleName(seller.getRole().getName());
        return dto;
    }

    public SellerResponseDto convertToDto(Seller seller) {
        SellerResponseDto dto = new SellerResponseDto();

        dto.setId(seller.getId());
        dto.setSellerName(seller.getSellerName());
        dto.setEmail(seller.getEmail());
        dto.setBusinessName(seller.getBusinessName());
        dto.setFirstName(seller.getFirstName());
        dto.setLastName(seller.getLastName());
        dto.setRating(seller.getRating());
        dto.setRoleName(seller.getRole().getName());
        return dto;
    }
}
