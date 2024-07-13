package group40.whatrentsellerapp.dto.sellerDto;

import group40.whatrentsellerapp.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerResponseDto {
    private Long id;
    private String sellerName;
    private String email;
    private String businessName;
    private String firstName;
    private String lastName;
    private Double rating;
    private String roleName;
}
