package fr.energie.billing.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;


@Entity
public class Customer {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String reference;

    @OneToOne(mappedBy = "customer")
    private Person person;

    @OneToOne(mappedBy = "customer")
    private Business business;

    @OneToMany(mappedBy = "customer")
    private Set<ElectricityConsumptionDetail> customerElectricityConsumptionDetails;

    @OneToMany(mappedBy = "customer")
    private Set<GazConsumptionDetail> customerGazConsumptionDetails;

    @OneToMany(mappedBy = "customer")
    private Set<Bill> customerBills;

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(final Integer id) {
//        this.id = id;
//    }
//
//    public String getReference() {
//        return reference;
//    }
//
//    public void setReference(final String reference) {
//        this.reference = reference;
//    }
//
//    public Set<Person> getCustomerPersons() {
//        return customerPersons;
//    }
//
//    public void setCustomerPersons(final Set<Person> customerPersons) {
//        this.customerPersons = customerPersons;
//    }
//
//    public Set<Business> getCustomerBusinesses() {
//        return customerBusinesses;
//    }
//
//    public void setCustomerBusinesses(final Set<Business> customerBusinesses) {
//        this.customerBusinesses = customerBusinesses;
//    }
//
//    public Set<ElectricityConsumptionDetail> getCustomerElectricityConsumptionDetails() {
//        return customerElectricityConsumptionDetails;
//    }
//
//    public void setCustomerElectricityConsumptionDetails(
//            final Set<ElectricityConsumptionDetail> customerElectricityConsumptionDetails) {
//        this.customerElectricityConsumptionDetails = customerElectricityConsumptionDetails;
//    }
//
//    public Set<GazConsumptionDetail> getCustomerGazConsumptionDetails() {
//        return customerGazConsumptionDetails;
//    }
//
//    public void setCustomerGazConsumptionDetails(
//            final Set<GazConsumptionDetail> customerGazConsumptionDetails) {
//        this.customerGazConsumptionDetails = customerGazConsumptionDetails;
//    }
//
//    public Set<Bill> getCustomerBills() {
//        return customerBills;
//    }
//
//    public void setCustomerBills(final Set<Bill> customerBills) {
//        this.customerBills = customerBills;
//    }

}
