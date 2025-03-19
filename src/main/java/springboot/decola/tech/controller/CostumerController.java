package springboot.decola.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.decola.tech.entity.Costumer;
import springboot.decola.tech.repository.CostumerRepository;
import springboot.decola.tech.service.CostumerService;

import java.util.List;

@RestController
@RequestMapping("/costumer")
public class CostumerController {

    @Autowired
    private CostumerService costumerService;

    @PostMapping("/save")
    public ResponseEntity save( @RequestBody Costumer costumer) {
        costumerService.saveCostumer(costumer);

        return ResponseEntity.ok().body(costumer);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Costumer>> search(@PathVariable String name) {
        List<Costumer> costumer = costumerService.findByNameCostumer(name);

        if (costumer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(costumer);

    }

    @GetMapping("/costumers-list")
    public ResponseEntity<List<Costumer>> findAllCostumers() {

        List<Costumer> costumers = costumerService.findAllCostumers();

        return ResponseEntity.ok().body(costumers);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Costumer> delete(@PathVariable Long id) {
        Costumer costumer = costumerService.deleteCostumer(id);

        return ResponseEntity.ok().body(costumer);
    }

}
