package fr.energie.billing;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import fr.energie.billing.domain.Tariff;
import fr.energie.billing.repos.TariffRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BillingApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class TariffInitialization {

	@Autowired
	private TariffRepository tariffRepository;
	
	/**
	 * Pour les particuliers, 
	 * le prix du kWh est de 0,133 € pour l'électricité et 0,108€ pour le gaz
	 */
	@Test
	public void initializePersonalTariff() {
		BigDecimal electricityPrice = new BigDecimal(Float.valueOf(0.133f));
		BigDecimal gazPrice = new BigDecimal(Float.valueOf(0.108f));
		Tariff particularTariff = new Tariff("PRS", "Tarif pour les particuliers", electricityPrice, gazPrice);
		tariffRepository.save(particularTariff);
	}
	
	/**
	 * Pour les pro, ayant un CA inférieur à 1 000 000 €, 
	 * le prix du kWh est de 0,112 € pour l'électricité et 0,117€ pour le gaz
	 */
	@Test
	public void initializePmeTariff() {
		BigDecimal electricityPrice = new BigDecimal(Float.valueOf(0.112f));
		BigDecimal gazPrice = new BigDecimal(Float.valueOf(0.117f));
		Tariff particularTariff = new Tariff("PME", "Tarif pour les PME, dont le capital <= 1 000 000 ", electricityPrice, gazPrice);
		tariffRepository.save(particularTariff);
	}
	
	/**
	 * Pour les pro, ayant un CA supérieur à 1 000 000 €, 
	 * le prix du kWh est de 0,110 € pour l'électricité et 0,123€ pour le gaz
	 */
	@Test
	public void initializeGeTariff() {
		BigDecimal electricityPrice = new BigDecimal(Float.valueOf(0.110f));
		BigDecimal gazPrice = new BigDecimal(Float.valueOf(0.123f));
		Tariff particularTariff = new Tariff("GE", "Tarif pour les GE, dont le capital > 1 000 000 €", electricityPrice, gazPrice);
		tariffRepository.save(particularTariff);
	}
}
