package fr.energie.billing.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;


@Entity
public class ElectricityConsumptionDetail {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDate consumptionDate;

    @Column
    private Integer consumption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(final Integer id) {
//        this.id = id;
//    }
//
//    public LocalDate getConsumptionDate() {
//        return consumptionDate;
//    }
//
//    public void setConsumptionDate(final LocalDate consumptionDate) {
//        this.consumptionDate = consumptionDate;
//    }
//
//    public Integer getConsumption() {
//        return consumption;
//    }
//
//    public void setConsumption(final Integer consumption) {
//        this.consumption = consumption;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(final Customer customer) {
//        this.customer = customer;
//    }

}
