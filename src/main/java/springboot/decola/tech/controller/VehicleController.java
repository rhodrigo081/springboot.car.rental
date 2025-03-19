package springboot.decola.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.decola.tech.entity.Branch;
import springboot.decola.tech.entity.Vehicle;
import springboot.decola.tech.entity.VehicleType;
import springboot.decola.tech.repository.BranchRepository;
import springboot.decola.tech.repository.VehicleRepository;
import springboot.decola.tech.repository.VehicleTypeRepository;
import springboot.decola.tech.service.VehicleService;
import springboot.decola.tech.service.VehicleTypeService;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/save")
    public ResponseEntity<Vehicle> save(@RequestBody Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        if (vehicle.getIdVehicle() != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/search/{plate}")
    public ResponseEntity<List<Vehicle>> search(@PathVariable String plate) {
        List<Vehicle> vehicle = vehicleService.findByPlateVehicle(plate);
        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(vehicle);
    }

    @GetMapping("/vehicles-list")
    public ResponseEntity<List<Vehicle>> findAll() {
        List<Vehicle> vehicles = vehicleService.findAllVehicles();

        return ResponseEntity.ok().body(vehicles);
    }

    @DeleteMapping("/delete/{plate}")
    public ResponseEntity<Vehicle> delete(@PathVariable String plate) {
        Vehicle vehicle = vehicleService.deleteVehicleByPlate(plate);

        if (vehicle == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(vehicle);
    }

}
