package group40.whatrentsellerapp.repository;

import group40.whatrentsellerapp.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findById(Long id);
    Optional<Seller> findBySellerName(String sellerName);
    Optional<Seller> findByEmail(String sellerEmail);

    @Modifying
    @Query("UPDATE Seller s SET s.password = :password WHERE s.email = :email")
    int updateSellerPasswordByEmail(@Param("password") String password, @Param("email") String email);

    @Modifying
    @Query("UPDATE Seller s SET s.sellerName = :name WHERE s.email = :email")
    int updateSellerNameByEmail(@Param("name") String name, @Param("email") String email);
}
