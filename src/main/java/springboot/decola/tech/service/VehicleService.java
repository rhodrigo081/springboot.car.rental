package springboot.decola.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.decola.tech.entity.Branch;
import springboot.decola.tech.entity.Vehicle;
import springboot.decola.tech.entity.VehicleType;
import springboot.decola.tech.repository.BranchRepository;
import springboot.decola.tech.repository.VehicleRepository;
import springboot.decola.tech.repository.VehicleTypeRepository;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public void saveVehicle(Vehicle vehicle) {
        Branch branch = branchRepository.findById(vehicle.getBranch().getId()).orElse(null);
        VehicleType vehicleType = vehicleTypeRepository.findById(vehicle.getVehicleType().getId()).orElse(null);

        if (branch == null || vehicleType == null) {
            System.out.println("Erro: Branch ou VehicleType não encontrados");
            return;
        }

        vehicle.setBranch(branch);
        vehicle.setVehicleType(vehicleType);

        vehicleRepository.save(vehicle);
    }

    public List<Vehicle> findByPlateVehicle(String plate) {
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
