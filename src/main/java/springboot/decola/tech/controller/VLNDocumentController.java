package springboot.decola.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.decola.tech.entity.Costumer;
import springboot.decola.tech.entity.VLNDocument;
import springboot.decola.tech.entity.Vehicle;
import springboot.decola.tech.repository.CostumerRepository;
import springboot.decola.tech.repository.VehicleRepository;
import springboot.decola.tech.service.VLNDocumentService;

import java.util.List;

@RestController
@RequestMapping("/vln-document")
public class VLNDocumentController {

    @Autowired
    private VLNDocumentService vlnDocumentService;
    @Autowired
    private CostumerRepository costumerRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody VLNDocument vLNDocument) {

        Costumer costumer = costumerRepository.findById(vLNDocument.getCostumer().getId()).orElse(null);
        Vehicle vehicle = vehicleRepository.findById(vLNDocument.getVehicle().getId()).orElse(null);

        if (costumer == null && vehicle== null) {
            return ResponseEntity.badRequest().body("Costumer ou Vehicle não encontrado");
        } else {
            vLNDocument.setCostumer(costumer);
            vLNDocument.setVehicle(vehicle);

            vlnDocumentService.save(vLNDocument);

            return ResponseEntity.ok().body(vLNDocument);
        }


    }


    @GetMapping("/search/{costumerId}")
    public ResponseEntity<List<VLNDocument>> search(@PathVariable Long costumerId) {

        List<VLNDocument> vLNDocument = vlnDocumentService.findVLNByCostumerId(costumerId);

        if (vLNDocument == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(vLNDocument);
    }

    @GetMapping("/vln-documents-list")
    public ResponseEntity<List<VLNDocument>> findAll() {
        List<VLNDocument> vLNDocuments = vlnDocumentService.findAll();

        return ResponseEntity.ok().body(vLNDocuments);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<VLNDocument> delete(@PathVariable Long id) {
        VLNDocument vLNDocument = vlnDocumentService.deleteVLNDocument(id);

        if (vLNDocument == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(vLNDocument);
    }

}
