package springboot.decola.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.decola.tech.entity.VLNDocument;
import springboot.decola.tech.repository.VLNDocumentRepository;

import java.util.List;

@Service
public class VLNDocumentService {

    @Autowired
    private VLNDocumentRepository vLNDocumentRepository;

    public VLNDocument save(VLNDocument vLNDocument) {
        return vLNDocumentRepository.save(vLNDocument);
    }

    public List<VLNDocument> findVLNByCostumerId(Long costumerId) {
        return vLNDocumentRepository.findByCostumerId(costumerId);
    }

    public List<VLNDocument> findAll() {
        return vLNDocumentRepository.findAll();
    }

    public VLNDocument deleteVLNDocument(Long id) {
        VLNDocument vLNDocument = vLNDocumentRepository.findById(id).orElse(null);
        if (vLNDocument != null) {
            vLNDocumentRepository.deleteById(id);
        }
        return vLNDocument;
    }

}
