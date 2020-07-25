package com.example.form.editors;

import java.beans.PropertyEditorSupport;

import com.example.form.services.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryPropertyEditor extends PropertyEditorSupport {

	@Autowired
	private CountryService countryService;

	@Override
	public void setAsText(String countryId) throws IllegalArgumentException {
		try {
			Integer id = Integer.parseInt(countryId);
			setValue(countryService.findById(id));
		} catch (NumberFormatException e) {
			setValue(null);
		}
	}
	
}
