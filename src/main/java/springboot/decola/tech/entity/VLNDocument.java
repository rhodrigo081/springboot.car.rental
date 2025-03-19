package springboot.decola.tech.entity;


import jakarta.persistence.*;



import java.util.Date;

@Entity
public class VLNDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;

    private Double documentValue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "costumer_id")
    private Costumer costumer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDocumentValue() {
        return documentValue;
    }

    public void setDocumentValue(Double documentValue) {
        this.documentValue = documentValue;
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
