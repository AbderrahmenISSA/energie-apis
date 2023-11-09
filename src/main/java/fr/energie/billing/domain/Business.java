package fr.energie.billing.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;


@Entity
public class Business {

    @Id
    @Column(nullable = false, updatable = false, length = 45)
    private String name;

    @Column(length = 45)
    private String siret;

    @Column(precision = 10, scale = 2)
    private BigDecimal capital;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

//    public String getName() {
//        return name;
//    }
//
//    public void setName(final String name) {
//        this.name = name;
//    }
//
//    public String getSiret() {
//        return siret;
//    }
//
//    public void setSiret(final String siret) {
//        this.siret = siret;
//    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(final BigDecimal capital) {
        this.capital = capital;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

}
