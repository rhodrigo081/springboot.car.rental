package springboot.decola.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.decola.tech.entity.Costumer;
import springboot.decola.tech.repository.CostumerRepository;

import java.util.List;

@RestController
@RequestMapping("/costumer")
public class CostumerController {

    @Autowired
    private CostumerRepository costumerRepository;

    @PostMapping("/save")
    public ResponseEntity save( @RequestBody Costumer costumer) {
        costumerRepository.save(costumer);

        return ResponseEntity.ok().body(costumer);
    }

    @GetMapping("/search/{nameCostumer}")
    public ResponseEntity<List<Costumer>> search(@PathVariable String nameCostumer) {
        List<Costumer> costumer = costumerRepository.findByNameCostumer(nameCostumer);

        if (costumer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(costumer);

    }

    @GetMapping("/costumers-list")
    public ResponseEntity<List<Costumer>> findAllCostumers() {

        List<Costumer> costumers = costumerRepository.findAll();

        return ResponseEntity.ok().body(costumers);

    }

    @DeleteMapping("/delete/{idCostumer}")
    public ResponseEntity delete(@PathVariable long idCostumer) {
        costumerRepository.deleteById(idCostumer);

        if (!costumerRepository.existsById(idCostumer)) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().build();
    }

}
