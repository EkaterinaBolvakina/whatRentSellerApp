package group40.whatrentsellerapp.controller.sellerController;


import group40.whatrentsellerapp.dto.sellerDto.SellerCreateRequestDto;
import group40.whatrentsellerapp.dto.sellerDto.SellerCreateResponseDto;
import group40.whatrentsellerapp.service.sellerService.AddSellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
@AllArgsConstructor
public class AddSellerController {

    private final AddSellerService addSellerService;

    @PostMapping("/addNew")
    public ResponseEntity<SellerCreateResponseDto> addSeller(@RequestBody SellerCreateRequestDto sellerCreateRequestDto) {
        return addSellerService.addSeller(sellerCreateRequestDto);
    }
}
