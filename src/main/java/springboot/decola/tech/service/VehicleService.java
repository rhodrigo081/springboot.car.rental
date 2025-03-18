package springboot.decola.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.decola.tech.entity.Vehicle;
import springboot.decola.tech.repository.VehicleRepository;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> findVehicleByPlate(String plate) {
        return vehicleRepository.findVehicleByPlate(plate);
    }

    public List<Vehicle> findAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle deleteVehicleByPlate(String plate) {
        List<Vehicle> vehicles = vehicleRepository.findVehicleByPlate(plate);
        if (!vehicles.isEmpty()) {
            Vehicle vehicle = vehicles.get(0);
            vehicleRepository.delete(vehicle);
            return vehicle;
        }
        return null;
    }
}
