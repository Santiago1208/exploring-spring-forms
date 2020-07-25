package com.example.form.services;

import java.util.Arrays;
import java.util.List;

import com.example.form.model.domain.Country;

import org.springframework.stereotype.Service;

@Service
public class CountryServiceImp implements CountryService {

	private List<Country> countries;

	public CountryServiceImp() {
		Country c1 = new Country(1, "ES", "Spain");
		Country c2 = new Country(2, "MX", "Mexico");
		Country c3 = new Country(3, "CH", "Chile");
		Country c4 = new Country(4, "AR", "Argentina");
		Country c5 = new Country(5, "PE", "Peru");
		Country c6 = new Country(6, "CO", "Colombia");
		Country c7 = new Country(7, "VZ", "Venezuela");
		countries = Arrays.asList(c1, c2, c3, c4, c5, c6, c7);
	}

	@Override
	public List<Country> getCountries() {
		return countries;
	}

	@Override
	public Country findById(Integer id) {
		Country result = null;
		for (int i = 0; i < countries.size() && result == null; i++) {
			Country currentCountry = countries.get(i);
			if (currentCountry.getId() == id) {
				result = currentCountry;
			}
		}
		return result;
	}
	
}
