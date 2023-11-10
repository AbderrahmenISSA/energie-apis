package fr.energie.billing.domain;

import java.math.BigDecimal;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Business {

	@Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(nullable = false, length = 45)
    private String name;

    @Column(length = 45)
    private String siret;

    @Column(precision = 10, scale = 2)
    private BigDecimal capital;

    @OneToOne(cascade = CascadeType.ALL ) 
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    /**
     * 
     * @param name
     * @param siret
     * @param capital
     * @param reference
     */
	public Business(String name, String siret, BigDecimal capital, String reference) {
		this.name = name;
		this.siret = siret;
		this.capital = capital;
		this.customer = new Customer(reference);
	}

	@Override
	public String toString() {
		return "Business [" + name + ", siret=" + siret + ", capital=" + capital + "€, reference=" + customer.getReference() + "]";
	}
    
}
