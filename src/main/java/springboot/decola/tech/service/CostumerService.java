package springboot.decola.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.decola.tech.entity.Costumer;
import springboot.decola.tech.repository.CostumerRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;

    public Costumer saveCostumer(Costumer costumer) {

        if (costumer.getCpf() == null || costumer.getCpf().isEmpty()
        || costumer.getName() == null || costumer.getName().isEmpty()
        || costumer.getEmail() == null || costumer.getEmail().isEmpty()
        || costumer.getPhone() == null || costumer.getPhone().isEmpty() ) {
            throw new IllegalArgumentException("Fill in all fields");
        }

        return costumerRepository.save(costumer);
    }

    public List<Costumer> findByNameCostumer(String name) {

        List<Costumer> searchedCostumer = costumerRepository.findByName(name);

        if (searchedCostumer.isEmpty() || searchedCostumer == null) {
            throw new NoSuchElementException("Costumer does not exist");
        }

        return costumerRepository.findByName(name);
    }

    public List<Costumer> findAllCostumers() {

        List<Costumer> costumers = costumerRepository.findAll();

        if (costumers.isEmpty() || costumers == null) {
            throw new NoSuchElementException("No costumers created");
        }

        return costumerRepository.findAll();
    }

    public Costumer deleteCostumer(Long id) {

        Costumer deletedCostumer = costumerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Costumer does not exist"));

        return deletedCostumer;
    }
}
