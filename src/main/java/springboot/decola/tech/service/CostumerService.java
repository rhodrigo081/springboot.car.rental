package springboot.decola.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.decola.tech.entity.Costumer;
import springboot.decola.tech.repository.CostumerRepository;

import java.util.List;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;

    public Costumer saveCostumer(Costumer costumer) {
        return costumerRepository.save(costumer);
    }

    public List<Costumer> findByNameCostumer(String nameCostumer) {
        return costumerRepository.findByNameCostumer(nameCostumer);
    }

    public List<Costumer> findAllCostumer() {
        return costumerRepository.findAll();
    }

    public Costumer deleteCostumer(Long idCostumer) {
        Costumer costumer = costumerRepository.findById(idCostumer).orElse(null);
        if (costumer != null) {
            costumerRepository.delete(costumer);
        }
        return costumer;
    }

}
