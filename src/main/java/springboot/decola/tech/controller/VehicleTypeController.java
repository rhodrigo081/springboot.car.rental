package springboot.decola.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.decola.tech.entity.VehicleType;
import springboot.decola.tech.service.VehicleTypeService;

@RestController
@RequestMapping("/vehicle-type")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @PostMapping("/save")
    public ResponseEntity<VehicleType> save(@RequestBody VehicleType vehicleType) {
        vehicleTypeService.saveVehicleType(vehicleType);

        return ResponseEntity.ok().body(vehicleType);
    }

    @GetMapping("/list-vehicle-types")
    public ResponseEntity findAll() {
        return ResponseEntity.ok().body(vehicleTypeService.findAllVehicleTypes());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<VehicleType> delete(@PathVariable Long id) {
        VehicleType vehicleType = vehicleTypeService.deleteVehicleType(id);

        if (vehicleType == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(vehicleType);
    }

}
