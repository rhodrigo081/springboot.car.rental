package springboot.decola.tech.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicle;
    private String plate;
    private String model;
    private String color;

    @OneToMany(mappedBy = "vehicle")
    @JsonManagedReference
    private Set<VLNDocument> vlnDocuments;

    @ManyToOne
    @JoinColumn(name = "idBranch")
    @JsonBackReference
    private Branch branch;

    @ManyToOne
    @JoinColumn(name = "idVehicleType")
    @JsonBackReference
    private VehicleType vehicleType;

    public Long getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Long idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<VLNDocument> getVlnDocuments() {
        return vlnDocuments;
    }

    public void setVlnDocuments(Set<VLNDocument> vlnDocuments) {
        this.vlnDocuments = vlnDocuments;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}

