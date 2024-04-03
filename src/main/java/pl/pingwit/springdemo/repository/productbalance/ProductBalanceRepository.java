package pl.pingwit.springdemo.repository.productbalance;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductBalanceRepository extends JpaRepository<ProductBalance, Integer> {

    Optional<ProductBalance> findByProductId(Integer productId);
}
