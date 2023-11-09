package fr.energie.billing.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.energie.billing.domain.ElectricityConsumptionDetail;


public interface ElectricityConsumptionDetailRepository extends JpaRepository<ElectricityConsumptionDetail, Integer> {
}
