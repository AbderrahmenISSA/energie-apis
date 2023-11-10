package fr.energie.billing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.energie.billing.domain.MonthlyConsumption;
import fr.energie.billing.dto.BillDTO;
import fr.energie.billing.repos.MonthlyConsumptionRepository;
import fr.energie.billing.utils.BillDtoUtils;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(path = BillingController.BILLING)
public class BillingController {
	
	protected static final String BILLING = "v1/billing";
	
	@Autowired
	private MonthlyConsumptionRepository consumptionRepository;
	
	@GetMapping("customer/{reference}")
	public RestResponse getBillsOfCustomer(@PathParam("reference") String reference) {
		List<MonthlyConsumption> consumptions = consumptionRepository.findByCustomerReference(reference);
		List<BillDTO> bills = BillDtoUtils.convertToDTOs(consumptions);
		return new RestResponse(HttpStatus.OK.value(), bills);
	}
	
}
