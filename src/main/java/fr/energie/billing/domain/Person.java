package fr.energie.billing.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Person {

    @Id
    @Column(nullable = false, updatable = false, length = 45)
    private String civility;

    @Column(length = 45)
    private String firstname;

    @Column(length = 45)
    private String lastname;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

//    public String getCivility() {
//        return civility;
//    }
//
//    public void setCivility(final String civility) {
//        this.civility = civility;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(final String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(final String lastname) {
//        this.lastname = lastname;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(final Customer customer) {
//        this.customer = customer;
//    }

}
