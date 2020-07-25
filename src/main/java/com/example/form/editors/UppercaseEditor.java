package com.example.form.editors;

import java.beans.PropertyEditorSupport;

public class UppercaseEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(text.toUpperCase());
	}
	
}
