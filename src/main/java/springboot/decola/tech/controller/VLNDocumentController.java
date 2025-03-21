package springboot.decola.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.decola.tech.entity.VLNDocument;
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
    public ResponseEntity saveVLNDocument(@RequestBody VLNDocument vLNDocument) {

            VLNDocument savedVLNDocument = vlnDocumentService.saveVLNDocument(vLNDocument);

            return ResponseEntity.ok().body(savedVLNDocument);

    }

    @GetMapping("/search/{costumerId}/{vehicleId}/{documentId}")
    public ResponseEntity<VLNDocument> searchVLNDocument(@PathVariable Long costumerId, @PathVariable Long vehicleId, @PathVariable Long documentId) {

        VLNDocument searchedVLNDocument = vlnDocumentService.searchVLNDocument(costumerId, vehicleId, documentId);

        return ResponseEntity.ok().body(searchedVLNDocument);
    }

    @GetMapping("/vln-documents-list")
    public ResponseEntity<List<VLNDocument>> listAllVLNDocuments() {

        List<VLNDocument> vLNDocuments = vlnDocumentService.listAllVLNDocuments();

        return ResponseEntity.ok().body(vLNDocuments);
    }

    @DeleteMapping("/delete/{costumerId}/{vehicleId}/{documentId}")
    public ResponseEntity<VLNDocument> deleteVLNDocument(@PathVariable Long costumerId, @PathVariable Long vehicleId, @PathVariable Long documentId){

        VLNDocument deletedVLNDocument = vlnDocumentService.deleteVLNDocument(costumerId, vehicleId, documentId);

        return ResponseEntity.ok().body(deletedVLNDocument);
    }

}
