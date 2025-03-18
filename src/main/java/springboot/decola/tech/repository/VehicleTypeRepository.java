package springboot.decola.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.decola.tech.entity.VehicleType;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
}
