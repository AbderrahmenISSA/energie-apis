package fr.energie.billing.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.energie.billing.domain.Bill;


public interface BillRepository extends JpaRepository<Bill, Integer> {
}
