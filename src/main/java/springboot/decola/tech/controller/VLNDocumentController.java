package springboot.decola.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.decola.tech.entity.VLNDocument;
import springboot.decola.tech.service.VLNDocumentService;

import java.util.List;

@RestController
@RequestMapping("/vln-document")
public class VLNDocumentController {

    @Autowired
    private VLNDocumentService vlnDocumentService;

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody VLNDocument vLNDocument) {
        vlnDocumentService.save(vLNDocument);

        return ResponseEntity.ok().body(vLNDocument);
    }


    @GetMapping("/search/{costumerId}")
    public ResponseEntity<List<VLNDocument>> search(@PathVariable Long costumerId) {

        List<VLNDocument> vLNDocument = vlnDocumentService.findVLNByCostumerId(costumerId);

        if (vLNDocument == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(vLNDocument);
    }

    @GetMapping("/list-vln-documents")
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
