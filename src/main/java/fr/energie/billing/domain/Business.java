package fr.energie.billing.domain;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Business {

    @Id
    @Column(nullable = false, updatable = false, length = 45)
    private String name;

    @Column(length = 45)
    private String siret;

    @Column(precision = 10, scale = 2)
    private BigDecimal capital;

    @OneToOne(cascade = CascadeType.ALL ) 
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
