package springboot.decola.tech.entity;

import jakarta.persistence.Entity;

@Entity
public class CostumerPJ extends Costumer{

    private String cnpjCostumer;
    private String corporateReason;
    private String registration;

    public String getCnpjCostumer() {
        return cnpjCostumer;
    }

    public void setCnpjCostumer(String cnpjCostumer) {
        this.cnpjCostumer = cnpjCostumer;
    }

    public String getCorporateReason() {
        return corporateReason;
    }

    public void setCorporateReason(String corporateReason) {
        this.corporateReason = corporateReason;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
