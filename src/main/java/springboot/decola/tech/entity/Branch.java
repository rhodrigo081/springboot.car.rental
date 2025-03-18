package springboot.decola.tech.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBranch;
    private String cnpjBranch;
    private String phoneBranch;
    private String nameBranch;

    @OneToMany(mappedBy = "branch")
    @JsonIgnore
    private Set<Costumer> costumers;

    @OneToMany(mappedBy = "branch")
    @JsonIgnore
    private Set<Vehicle> vehicles;

    public Long getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Long idBranch) {
        this.idBranch = idBranch;
    }

    public String getCnpjBranch() {
        return cnpjBranch;
    }

    public void setCnpjBranch(String cnpjBranch) {
        this.cnpjBranch = cnpjBranch;
    }

    public String getPhoneBranch() {
        return phoneBranch;
    }

    public void setPhoneBranch(String phoneBranch) {
        this.phoneBranch = phoneBranch;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public Set<Costumer> getCostumers() {
        return costumers;
    }

    public void setCostumers(Set<Costumer> costumers) {
        this.costumers = costumers;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
