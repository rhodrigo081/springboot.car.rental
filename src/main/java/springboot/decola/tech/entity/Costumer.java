package springboot.decola.tech.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Costumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCostumer;
    private String nameCostumer;
    private String phoneCostumer;
    private String emailCostumer;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    @JsonIgnore
    private Branch branch;

    @OneToMany(mappedBy = "costumer")
    @JsonIgnore
    private Set<VLNDocument> vlnDocuments;

    public Long getIdCostumer() {
        return idCostumer;
    }

    public void setIdCostumer(Long idCostumer) {
        this.idCostumer = idCostumer;
    }

    public String getNameCostumer() {
        return nameCostumer;
    }

    public void setNameCostumer(String nameCostumer) {
        this.nameCostumer = nameCostumer;
    }

    public String getPhoneCostumer() {
        return phoneCostumer;
    }

    public void setPhoneCostumer(String phoneCostumer) {
        this.phoneCostumer = phoneCostumer;
    }

    public String getEmailCostumer() {
        return emailCostumer;
    }

    public void setEmailCostumer(String emailCostumer) {
        this.emailCostumer = emailCostumer;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Set<VLNDocument> getVlnDocuments() {
        return vlnDocuments;
    }

    public void setVlnDocuments(Set<VLNDocument> vlnDocuments) {
        this.vlnDocuments = vlnDocuments;
    }
}
