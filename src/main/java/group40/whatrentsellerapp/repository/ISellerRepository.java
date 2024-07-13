package group40.whatrentsellerapp.repository;

import group40.whatrentsellerapp.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ISellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findBySellerId(Long sellerId);
}
