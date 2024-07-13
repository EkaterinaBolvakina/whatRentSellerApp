package group40.whatrentsellerapp.controller.sellerController;

import group40.whatrentsellerapp.dto.sellerDto.SellerResponseDto;
import group40.whatrentsellerapp.service.sellerService.FindSellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
@AllArgsConstructor
public class FindSellerController {
    private final FindSellerService findSellerService;

    @GetMapping
    public ResponseEntity<List<SellerResponseDto>> findAllSellers() {
        return findSellerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SellerResponseDto> findSellerById(@PathVariable Long id) {
        return findSellerService.findById(id);
    }

    @GetMapping("/findByName")
    public ResponseEntity<SellerResponseDto> findSellerByName(@RequestParam(value = "sellerName") String name) {
        return findSellerService.findBySellerName(name);
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<SellerResponseDto> findSellerByEmail(@RequestParam(value = "email") String email) {
        return findSellerService.findBySellerEmail(email);
    }

}
