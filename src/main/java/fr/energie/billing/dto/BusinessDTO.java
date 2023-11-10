package fr.energie.billing.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
public class BusinessDTO {
	
    private String name;
    private String siret;
    private BigDecimal capital;
    private String reference;

}
