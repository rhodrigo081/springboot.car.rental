package springboot.decola.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.decola.tech.entity.VehicleType;
import springboot.decola.tech.service.VehicleTypeService;

import java.util.List;

@RestController
@RequestMapping("/vehicle-type")
public class VehicleTypeController {

    @Autowired
    private VehicleTypeService vehicleTypeService;

    @PostMapping("/save")
    public ResponseEntity<VehicleType> saveVehicleTypes(@RequestBody VehicleType vehicleType) {

        vehicleTypeService.saveVehicleType(vehicleType);

        return ResponseEntity.ok().body(vehicleType);
    }

    @GetMapping("/list-vehicle-types")
    public List<VehicleType> listAllVehicleTypes() {

        return vehicleTypeService.findAllVehicleTypes();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<VehicleType> deleteVehicleType(@PathVariable Long id) {

        VehicleType deletedVehicleType = vehicleTypeService.deleteVehicleType(id);


        return ResponseEntity.ok().body(deletedVehicleType);
    }

}
