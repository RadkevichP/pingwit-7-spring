package pl.pingwit.springdemo.repository.smallorder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SmallOrderRepository extends JpaRepository<SmallOrder, Integer> {
}
