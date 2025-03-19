package springboot.decola.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.decola.tech.entity.Costumer;

import java.util.List;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {
    List<Costumer> findByName(String name);
}
