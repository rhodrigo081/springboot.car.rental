package springboot.decola.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.decola.tech.entity.Costumer;
import springboot.decola.tech.entity.VLNDocument;
import springboot.decola.tech.entity.Vehicle;
import springboot.decola.tech.repository.CostumerRepository;
import springboot.decola.tech.repository.VLNDocumentRepository;
import springboot.decola.tech.repository.VehicleRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class VLNDocumentService {

    @Autowired
    private VLNDocumentRepository vLNDocumentRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private CostumerRepository costumerRepository;

    public VLNDocument saveVLNDocument(VLNDocument vLNDocument) {

        if (vLNDocument.getDate() == null || vLNDocument.getDocumentValue() == null
                || vLNDocument.getDocumentValue() == 0.00 || vLNDocument.getCostumer() == null
                || vLNDocument.getCostumer().getId() == null || vLNDocument.getVehicle() == null
                || vLNDocument.getVehicle().getId() == null) {
            throw new IllegalArgumentException("Fill in all fields");
        }

        Vehicle vehicle = vehicleRepository.findById(vLNDocument.getVehicle().getId())
                .orElseThrow(() -> new NoSuchElementException("Vehicle does not exist"));
        Costumer costumer = costumerRepository.findById(vLNDocument.getCostumer().getId())
                .orElseThrow(() -> new NoSuchElementException("Costumer does not exist"));

        vLNDocument.setCostumer(costumer);
        vLNDocument.setVehicle(vehicle);

        costumer.getVlnDocuments().add(vLNDocument);
        vehicle.getVlnDocuments().add(vLNDocument);

        return vLNDocumentRepository.save(vLNDocument);
    }

    public VLNDocument searchVLNDocument(Long costumerId, Long vehicleId, Long documentId) {

        VLNDocument vlnDocument = vLNDocumentRepository.findByIdAndCostumerIdAndVehicleId(costumerId, vehicleId, documentId)
                .orElseThrow(() -> new NoSuchElementException("VLN Document does not exist"));

        return vlnDocument;
    }

    public List<VLNDocument> listAllVLNDocuments() {

        List<VLNDocument> vlnDocuments = vLNDocumentRepository.findAll();

        if (vlnDocuments.isEmpty() || vlnDocuments == null) {
            throw new NoSuchElementException("No VLN Documents created");
        }

        return vLNDocumentRepository.findAll();
    }

    public VLNDocument deleteVLNDocument(Long costumerId, Long vehicleId, Long documentId) {
        VLNDocument deletedVLNDocument = vLNDocumentRepository.findByIdAndCostumerIdAndVehicleId(documentId, costumerId, vehicleId)
                .orElseThrow(() -> new NoSuchElementException("VLN Document does not exist"));

        vLNDocumentRepository.delete(deletedVLNDocument);

        return deletedVLNDocument;
    }

}
