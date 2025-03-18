package springboot.decola.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.decola.tech.entity.VLNDocument;

import java.util.List;

public interface VLNDocumentRepository extends JpaRepository<VLNDocument, Long> {
    List<VLNDocument> findVLNByCostumerIdCostumer (Long idCostumer);
}
