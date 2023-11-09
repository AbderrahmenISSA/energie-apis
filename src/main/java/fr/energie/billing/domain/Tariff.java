package fr.energie.billing.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;


@Entity
public class Tariff {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String code;

    @Column(length = 45)
    private String label;

    @Column(precision = 10, scale = 2)
    private BigDecimal kwhPrice;

    @Column(precision = 10, scale = 2)
    private BigDecimal gazPrice;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(final Integer id) {
//        this.id = id;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(final String code) {
//        this.code = code;
//    }
//
//    public String getLabel() {
//        return label;
//    }
//
//    public void setLabel(final String label) {
//        this.label = label;
//    }
//
//    public BigDecimal getKwhPrice() {
//        return kwhPrice;
//    }
//
//    public void setKwhPrice(final BigDecimal kwhPrice) {
//        this.kwhPrice = kwhPrice;
//    }
//
//    public BigDecimal getGazPrice() {
//        return gazPrice;
//    }
//
//    public void setGazPrice(final BigDecimal gazPrice) {
//        this.gazPrice = gazPrice;
//    }

}
