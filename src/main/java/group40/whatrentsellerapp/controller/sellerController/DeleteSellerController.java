package group40.whatrentsellerapp.controller.sellerController;

import group40.whatrentsellerapp.service.sellerService.DeleteSellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
@AllArgsConstructor
public class DeleteSellerController {
    private final DeleteSellerService deleteSellerService;

    // localhost:8080/seller/deleteByEmail?email=MaxMustermann@company.com
    @DeleteMapping("/deleteByEmail")
    public ResponseEntity<Void>  deleteByEmail(@RequestParam(value = "email") String email) {
        return deleteSellerService.deleteSellerByEmail(email);
    }
}
