package group40.whatrentsellerapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Seller name must be not blank")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Seller name can contain only latin character and digital")
    private String sellerName;

    @NotBlank(message = "Seller passwort must be not blank")
    @Size(min = 7, max = 15, message = "Password length must be between 7 and 15 characters")
    private String password;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Seller email must be not blank")
    private String email;

    @Column(name = "seller_business_name", nullable = false)
    private String businessName;

    //@NotBlank(message = "User first name must be not blank")
    private String firstName;
    //@NotBlank(message = "User last name must be not blank")
    private String lastName;

    @Column(name = "seller_rating")
    private Double rating;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Product> products;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
}
