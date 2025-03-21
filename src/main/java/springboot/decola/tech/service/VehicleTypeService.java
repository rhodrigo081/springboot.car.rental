package springboot.decola.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.decola.tech.entity.VehicleType;
import springboot.decola.tech.repository.VehicleTypeRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public VehicleType saveVehicleType(VehicleType vehicleType) {

        if (vehicleType.getName() == null || vehicleType.getName().isEmpty())
        {
            throw new IllegalArgumentException("Fill in all fields");
        }

        return vehicleTypeRepository.save(vehicleType);
    }

    public List<VehicleType> findAllVehicleTypes() {

        List<VehicleType> vehicleTypes = vehicleTypeRepository.findAll();

        if (vehicleTypes.isEmpty() || vehicleTypes == null) {
            throw new NoSuchElementException("No vehicle types created");
        }

        return vehicleTypes;
    }

    public VehicleType deleteVehicleType(Long id) {

        VehicleType deletedVehicleType = vehicleTypeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Vehicle type does not exist"));

        return deletedVehicleType;
    }


}
