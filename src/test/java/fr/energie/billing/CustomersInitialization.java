package fr.energie.billing;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import fr.energie.billing.domain.Business;
import fr.energie.billing.domain.ConsumptionDetail;
import fr.energie.billing.domain.Customer;
import fr.energie.billing.domain.Person;
import fr.energie.billing.repos.BusinessRepository;
import fr.energie.billing.repos.ConsumptionDetailRepository;
import fr.energie.billing.repos.CustomerRepository;
import fr.energie.billing.repos.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BillingApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public class CustomersInitialization {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private BusinessRepository businessRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ConsumptionDetailRepository consumptionRepository;

	@Test
	public void create10Persons() {

		for (int i = 0; i < 10; i++) {
			Person p = new Person("M./Mme.", "User" + RandomStringUtils.randomNumeric(3),
					"U" + RandomStringUtils.randomAlphanumeric(9).toUpperCase(),
					"EKL" + RandomStringUtils.randomNumeric(9));
			personRepository.save(p);
		}
	}

	@Test
	public void create10Pme() {

		for (int i = 0; i < 10; i++) {
			BigDecimal capital = new BigDecimal(Integer.valueOf(RandomStringUtils.randomNumeric(3)) * 1000);
			Business b = new Business("Firm" + RandomStringUtils.randomAlphanumeric(6).toUpperCase(),
					RandomStringUtils.randomNumeric(14), capital, "EKL" + RandomStringUtils.randomNumeric(9));
			businessRepository.save(b);

		}
	}

	@Test
	public void create10Ge() {

		for (int i = 0; i < 10; i++) {
			BigDecimal capital = new BigDecimal(Integer.valueOf(RandomStringUtils.randomNumeric(3)) * 1000000);
			Business b = new Business("Firm" + RandomStringUtils.randomAlphanumeric(6).toUpperCase(),
					RandomStringUtils.randomNumeric(14), capital, "EKL" + RandomStringUtils.randomNumeric(9));
			businessRepository.save(b);

		}
	}

	@Test
	public void createConsumptions2023() {

		List<Customer> customers = customerRepository.findAll();

		for (Customer customer : customers) {
			Calendar cal = Calendar.getInstance();
			int month = cal.get(Calendar.MONTH);
			int year = cal.get(Calendar.YEAR);
			cal.clear();
			cal.set(Calendar.YEAR, year);

			for (int currentMonth = month; currentMonth > 0; currentMonth--) {
				// first day :
				LocalDate firstDay = LocalDate.of(year, currentMonth, 1); // cal.getTime();
				System.out.println("firstDay=" + firstDay);

				// last day
				LocalDate lastDay = firstDay.plusDays(firstDay.lengthOfMonth() - 1);
				System.out.println("lastDay=" + lastDay);

				ConsumptionDetail consumed = new ConsumptionDetail(firstDay, lastDay,
						Integer.valueOf(RandomStringUtils.randomNumeric(3)),
						Integer.valueOf(RandomStringUtils.randomNumeric(3)), customer);

				consumptionRepository.save(consumed);

			}
		}
	}

}
