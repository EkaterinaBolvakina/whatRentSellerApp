package group40.whatrentsellerapp.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="product_name")
    @NotBlank(message = "Product name must be not blank")
    @NotNull(message = "Product name must be not null")
    @Size(min=3, max=25, message = "Product name length must be between 3 and 25 characters")
    private String name;

    @Column(name="product_description")
    @NotBlank(message = "Product description must be not blank")
    @Size(min=3, max=45, message = "Product description length must be between 3 and 45 characters")
    private String description;

    @Column(name="product_price")
    @NotBlank(message = "Product price must be not blank")
    private Double price;

    @Column(name="product_quantity")
    @NotBlank(message = "Product quantity must be not blank")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    // @JsonBackReference (um Endlosschleife zu vermeiden, verwendet man @JsonBackReference und @JsonManagedReference in Category über List<Product>.)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @Column(name="is_on_stock")
    @NotBlank(message = "Product onStock must be not blank")
    private Boolean isOnStock;

    public Product(String name, String description, Double price, Integer quantity, Category category, Seller seller, Boolean isOnStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.seller = seller;
        this.isOnStock = isOnStock;
    }
}
