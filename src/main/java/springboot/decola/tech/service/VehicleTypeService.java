package springboot.decola.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.decola.tech.entity.VehicleType;
import springboot.decola.tech.repository.VehicleTypeRepository;

import java.util.List;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    public VehicleType saveVehicleType(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }

    public List<VehicleType> findAllVehicleTypes() {
        return vehicleTypeRepository.findAll();
    }

    public VehicleType deleteVehicleType(Long id) {
        VehicleType vehicleType = vehicleTypeRepository.findById(id).orElse(null);
        if (vehicleType != null) {
            vehicleTypeRepository.delete(vehicleType);
        }
        return vehicleType;
    }

}
