package fr.energie.billing.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.energie.billing.domain.Business;


public interface BusinessRepository extends JpaRepository<Business, String> {
}
