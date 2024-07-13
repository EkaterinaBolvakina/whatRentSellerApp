package group40.whatrentsellerapp.repository;

import group40.whatrentsellerapp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findAllByNameContains(String name);
    public List<Product> findAllByDescriptionContains(String description);
    public List<Product> findAllByPriceEquals(Double price);
    public List<Product> findAllByQuantityEquals(Integer quantity);

    @Query("SELECT t FROM Product t WHERE t.price BETWEEN :priceMin AND :priceMax")
    public List<Product> findAllByPriceGreaterThanAndPriceLessThan(@Param("priceMin") Double priceMin, @Param("priceMax") Double priceMax);

    @Query("SELECT t FROM Product t WHERE t.price BETWEEN :priceMin AND :priceMax")
    public List<Product> findAllByPriceBetween(@Param("priceMin") Double priceMin, @Param("priceMax") Double priceMax);

    public List<Product> findAllByPriceLessThan(Double price1);
    public List<Product> findAllByPriceGreaterThan(Double price1);

    @Query("SELECT t FROM Product t WHERE t.quantity BETWEEN :quantityMin AND :quantityMax")
    public List<Product> findAllByQuantityBetween(@Param("quantityMin") Integer quantityMin, @Param("quantityMax") Integer quantityMax);

    default Map<String,Product> findProductByWithLongNames(Integer minLength){
        return findAll().stream()
                .filter(product -> product.getName() != null && product.getName().length() > minLength)
                .collect(Collectors.toMap(Product::getName, product -> product));
    };
}
