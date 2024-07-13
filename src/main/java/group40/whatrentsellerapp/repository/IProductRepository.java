package group40.whatrentsellerapp.repository;

import group40.whatrentsellerapp.domain.Category;
import group40.whatrentsellerapp.domain.Product;
import group40.whatrentsellerapp.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByNameContains(String name);
    List<Product> findAllByDescriptionContains(String description);
    List<Product> findAllByPriceEquals(Double price);
    List<Product> findAllByQuantityEquals(Integer quantity);
    List<Product> findAllByCategory(Category category);
    List<Product> findAllBySeller(Seller seller);


    @Query("SELECT t FROM Product t WHERE t.price BETWEEN :priceMin AND :priceMax")
    List<Product> findAllByPriceGreaterThanAndPriceLessThan(@Param("priceMin") Double priceMin, @Param("priceMax") Double priceMax);

    @Query("SELECT t FROM Product t WHERE t.price BETWEEN :priceMin AND :priceMax")
    List<Product> findAllByPriceBetween(@Param("priceMin") Double priceMin, @Param("priceMax") Double priceMax);

    List<Product> findAllByPriceLessThan(Double price1);
    List<Product> findAllByPriceGreaterThan(Double price1);

    @Query("SELECT t FROM Product t WHERE t.quantity BETWEEN :quantityMin AND :quantityMax")
    List<Product> findAllByQuantityBetween(@Param("quantityMin") Integer quantityMin, @Param("quantityMax") Integer quantityMax);

    default Map<String,Product> findProductByWithLongNames(Integer minLength){
        return findAll().stream()
                .filter(product -> product.getName() != null && product.getName().length() > minLength)
                .collect(Collectors.toMap(Product::getName, product -> product));
    };
}
