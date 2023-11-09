package fr.energie.billing.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.energie.billing.domain.Person;


public interface PersonRepository extends JpaRepository<Person, String> {
}
