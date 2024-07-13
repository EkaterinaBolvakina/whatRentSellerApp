package group40.whatrentsellerapp.dto.sellerDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerCreateRequestDto {
    @NotBlank(message = "Seller name must be not blank")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Seller name can contain only latin character and digital")
    private String sellerName;

    @NotBlank(message = "Seller passwort must be not blank")
    @Size(min = 7, max = 15, message = "Password length must be between 7 and 15 characters")
    private String password;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Seller email must be not blank")
    private String email;
}
