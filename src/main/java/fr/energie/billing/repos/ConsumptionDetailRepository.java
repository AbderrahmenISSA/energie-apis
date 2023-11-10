package fr.energie.billing.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.energie.billing.domain.ConsumptionDetail;


public interface ConsumptionDetailRepository extends JpaRepository<ConsumptionDetail, Integer> {
}
