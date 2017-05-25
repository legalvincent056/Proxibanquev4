package com.huios.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
@Component
@Scope("prototype")
@DiscriminatorValue("VISAELECTRON")
public class CarteVisaElectron extends CarteBancaire {

	@Override
	public String toString() {
		return "VisaElectron []";
	}

}
