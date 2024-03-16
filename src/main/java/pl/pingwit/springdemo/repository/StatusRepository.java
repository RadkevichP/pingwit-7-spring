package pl.pingwit.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {

    List<StatusEntity> findAllByDescriptionLikeIgnoreCase(String description);

}
