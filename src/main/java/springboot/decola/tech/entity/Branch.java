package springboot.decola.tech.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cnpj;
    private String phone;
    private String name;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private Set<Costumer> costumers = new HashSet<>();

    @OneToMany(mappedBy = "branch")
    @JsonManagedReference
    @JsonIgnore
    private Set<Vehicle> vehicles = new HashSet<>();

    public Branch() {}

    public Branch(String cnpj, String phone, String name) {
        this.cnpj = cnpj;
        this.phone = phone;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
