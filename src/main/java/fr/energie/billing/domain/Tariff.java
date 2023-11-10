package fr.energie.billing.domain;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Tariff {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45)
    private String code;

    @Column(length = 200)
    private String label;

    @Column(precision = 10, scale = 2)
    private BigDecimal electricityPrice;

    @Column(precision = 10, scale = 2)
    private BigDecimal gazPrice;

    /**
     * 
     * @param code
     * @param label
     * @param electricityPrice
     * @param gazPrice
     */
	public Tariff(String code, String label, BigDecimal electricityPrice, BigDecimal gazPrice) {
		super();
		this.code = code;
		this.label = label;
		this.electricityPrice = electricityPrice;
		this.gazPrice = gazPrice;
	}

}
