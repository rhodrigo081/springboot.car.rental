package springboot.decola.tech.entity;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class CostumerPF extends Costumer{

    private String cpfCostumer;
    private String genderCostumer;
    private Date birthDateCostumer;

    public String getCpfCostumer() {
        return cpfCostumer;
    }

    public void setCpfCostumer(String cpfCostumer) {
        this.cpfCostumer = cpfCostumer;
    }

    public String getGenderCostumer() {
        return genderCostumer;
    }

    public void setGenderCostumer(String genderCostumer) {
        this.genderCostumer = genderCostumer;
    }

    public Date getBirthDateCostumer() {
        return birthDateCostumer;
    }

    public void setBirthDateCostumer(Date birthDateCostumer) {
        this.birthDateCostumer = birthDateCostumer;
    }
}
