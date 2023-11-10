package fr.energie.billing.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Bill {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String period;

    @Column
    private LocalDate billDate;

    @Column
    private Integer comsumedElectricityKwh;

    @Column(precision = 10, scale = 2)
    private BigDecimal electricityPrice;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalElectricityAmount;

    @Column
    private Integer consumedGazKwh;

    @Column(precision = 10, scale = 2)
    private BigDecimal gazPrice;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalGazAmount;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
