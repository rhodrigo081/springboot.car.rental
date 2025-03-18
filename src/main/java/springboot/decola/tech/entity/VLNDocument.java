package springboot.decola.tech.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class VLNDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLease;
    private Date dateLease;
    private Double valueLease;

    @ManyToOne
    @JoinColumn(name = "idVehicle")
    @JsonIgnore
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "idCostumer")
    @JsonIgnore
    private Costumer costumer;

    public Long getIdLease() {
        return idLease;
    }

    public void setIdLease(Long idLease) {
        this.idLease = idLease;
    }

    public Date getDateLease() {
        return dateLease;
    }

    public void setDateLease(Date dateLease) {
        this.dateLease = dateLease;
    }

    public Double getValueLease() {
        return valueLease;
    }

    public void setValueLease(Double valueLease) {
        this.valueLease = valueLease;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }
}
