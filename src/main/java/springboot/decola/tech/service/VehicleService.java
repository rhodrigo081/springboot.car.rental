package springboot.decola.tech.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.decola.tech.entity.Branch;
import springboot.decola.tech.entity.Vehicle;
import springboot.decola.tech.entity.VehicleType;
import springboot.decola.tech.repository.BranchRepository;
import springboot.decola.tech.repository.VehicleRepository;
import springboot.decola.tech.repository.VehicleTypeRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    @Transactional
    public Vehicle saveVehicle(Vehicle vehicle) {

        if (vehicle.getPlate() == null || vehicle.getPlate().isEmpty()
                || vehicle.getColor() == null || vehicle.getColor().isEmpty()
                || vehicle.getModel() == null || vehicle.getModel().isEmpty()
                || vehicle.getBranch() == null || vehicle.getBranch().getId() == null
                || vehicle.getVehicleType() == null || vehicle.getVehicleType().getId() == null) {
            throw new IllegalArgumentException("Fill in all required field");
        }

        Branch branch = branchRepository.findById(vehicle.getBranch().getId())
                .orElseThrow(() -> new NoSuchElementException("Branch does not exist"));
        VehicleType vehicleType = vehicleTypeRepository.findById(vehicle.getVehicleType().getId())
                .orElseThrow(() -> new NoSuchElementException("Vehicle Type does not exist"));

        vehicle.setBranch(branch);
        vehicle.setVehicleType(vehicleType);

        branch.getVehicles().add(vehicle);
        vehicleType.getVehicles().add(vehicle);

        vehicleRepository.save(vehicle);
        return vehicle;
    }

    public List<Vehicle> findByPlateVehicle(String plate) {

        List<Vehicle> searchedVehicle = vehicleRepository.findVehicleByPlate(plate);

        if (searchedVehicle.isEmpty() || searchedVehicle == null) {
            throw new NoSuchElementException("Vehicle does not exist");
        }

        return searchedVehicle;
    }

    public List<Vehicle> findAllVehicles() {

        List<Vehicle> vehicles = vehicleRepository.findAll();

        if (vehicles.isEmpty() || vehicles == null) {
            throw new NoSuchElementException("No vehicles created");
        }

        return vehicles;
    }

    public Vehicle deleteVehicleByPlate(String plate) {
        List<Vehicle> vehicles = vehicleRepository.findVehicleByPlate(plate);
        if (!vehicles.isEmpty()) {
            Vehicle deletedVehicle = vehicles.get(0);
            vehicleRepository.delete(deletedVehicle);
            return deletedVehicle;
        } else {
            throw new NoSuchElementException("Vehicle does not exist");
        }
    }
}
