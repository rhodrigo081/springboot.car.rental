package springboot.decola.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.decola.tech.entity.Vehicle;
import springboot.decola.tech.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/save")
    public ResponseEntity<Vehicle> saveVehicle(@RequestBody Vehicle vehicle) {

        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);

        return ResponseEntity.ok().body(savedVehicle);

    }

    @GetMapping("/search/{plate}")
    public ResponseEntity<List<Vehicle>> searchVehicle(@PathVariable String plate) {

        List<Vehicle> searchedVehicle = vehicleService.findByPlateVehicle(plate);

        return ResponseEntity.ok().body(searchedVehicle);
    }

    @GetMapping("/vehicles-list")
    public List<Vehicle> listAllVehicles() {
        return vehicleService.findAllVehicles();
    }

    @DeleteMapping("/delete/{plate}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable String plate) {

        Vehicle deletedVehicle = vehicleService.deleteVehicleByPlate(plate);

        return ResponseEntity.ok().body(deletedVehicle);
    }

}
