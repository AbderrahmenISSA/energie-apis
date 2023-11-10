package fr.energie.billing.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.energie.billing.domain.MonthlyConsumption;


public interface MonthlyConsumptionRepository extends JpaRepository<MonthlyConsumption, Integer> {
	
	List<MonthlyConsumption> findByCustomerReference(String reference);
}
