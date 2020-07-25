package com.example.form.services;

import java.util.List;

import com.example.form.model.domain.Country;

public interface CountryService {
	
	public List<Country> getCountries();

	public Country findById(Integer id);

}
