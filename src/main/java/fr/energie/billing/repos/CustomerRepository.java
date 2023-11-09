package fr.energie.billing.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.energie.billing.domain.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
