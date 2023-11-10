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

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(final Integer id) {
//        this.id = id;
//    }
//
//    public String getPeriod() {
//        return period;
//    }
//
//    public void setPeriod(final String period) {
//        this.period = period;
//    }
//
//    public LocalDate getBillDate() {
//        return billDate;
//    }
//
//    public void setBillDate(final LocalDate billDate) {
//        this.billDate = billDate;
//    }
//
//    public Integer getComsumedElectricityKwh() {
//        return comsumedElectricityKwh;
//    }
//
//    public void setComsumedElectricityKwh(final Integer comsumedElectricityKwh) {
//        this.comsumedElectricityKwh = comsumedElectricityKwh;
//    }
//
//    public BigDecimal getElectricityPrice() {
//        return electricityPrice;
//    }
//
//    public void setElectricityPrice(final BigDecimal electricityPrice) {
//        this.electricityPrice = electricityPrice;
//    }
//
//    public BigDecimal getTotalElectricityAmount() {
//        return totalElectricityAmount;
//    }
//
//    public void setTotalElectricityAmount(final BigDecimal totalElectricityAmount) {
//        this.totalElectricityAmount = totalElectricityAmount;
//    }
//
//    public Integer getConsumedGazKwh() {
//        return consumedGazKwh;
//    }
//
//    public void setConsumedGazKwh(final Integer consumedGazKwh) {
//        this.consumedGazKwh = consumedGazKwh;
//    }
//
//    public BigDecimal getGazPrice() {
//        return gazPrice;
//    }
//
//    public void setGazPrice(final BigDecimal gazPrice) {
//        this.gazPrice = gazPrice;
//    }
//
//    public BigDecimal getTotalGazAmount() {
//        return totalGazAmount;
//    }
//
//    public void setTotalGazAmount(final BigDecimal totalGazAmount) {
//        this.totalGazAmount = totalGazAmount;
//    }
//
//    public BigDecimal getTotalAmount() {
//        return totalAmount;
//    }
//
//    public void setTotalAmount(final BigDecimal totalAmount) {
//        this.totalAmount = totalAmount;
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
