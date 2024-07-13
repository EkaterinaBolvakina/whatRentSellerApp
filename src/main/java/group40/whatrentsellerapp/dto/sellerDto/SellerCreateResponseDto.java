package group40.whatrentsellerapp.dto.sellerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerCreateResponseDto {
    private Long id;
    private String sellerName;
    private String roleName;
}
