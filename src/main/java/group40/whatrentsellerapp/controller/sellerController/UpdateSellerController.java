package group40.whatrentsellerapp.controller.sellerController;

import group40.whatrentsellerapp.dto.sellerDto.SellerCreateResponseDto;
import group40.whatrentsellerapp.service.sellerService.UpdateSellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
@AllArgsConstructor
public class UpdateSellerController {
    private final UpdateSellerService updateSellerService;

    // localhost:8080/seller/updatePassword?password=123456kKX12&email=MaxMustermann@company.com
    @PutMapping("/updatePassword")
    public ResponseEntity<SellerCreateResponseDto> updatePassword(@RequestParam(value = "password") String password, @RequestParam(value = "email") String email ) {
        return updateSellerService.updateSellerPasswordByEmail(password, email);
    }

    @PutMapping("/updateName")
    public ResponseEntity<SellerCreateResponseDto> updateName(@RequestParam(value = "name") String name, @RequestParam(value = "email") String email ) {
        return updateSellerService.updateSellerNameByEmail(name, email);
    }
}
