package fr.energie.billing.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.energie.billing.domain.GazConsumptionDetail;


public interface GazConsumptionDetailRepository extends JpaRepository<GazConsumptionDetail, Integer> {
}
