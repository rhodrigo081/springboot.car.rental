package springboot.decola.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import springboot.decola.tech.entity.VLNDocument;

import java.util.Optional;

public interface VLNDocumentRepository extends JpaRepository<VLNDocument, Long> {
    @Query("SELECT v FROM VLNDocument v WHERE v.id = :documentId AND v.costumer.id = :costumerId AND v.vehicle.id = :vehicleId")
    Optional<VLNDocument> findByIdAndCostumerIdAndVehicleId(@Param("documentId") Long documentId,
                                                            @Param("costumerId") Long costumerId,
                                                            @Param("vehicleId") Long vehicleId);
}
