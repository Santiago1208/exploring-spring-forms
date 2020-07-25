package com.example.form.model.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
// import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.example.form.validators.RegexId;
import com.example.form.validators.Required;

// import org.springframework.format.annotation.DateTimeFormat;

public class User {

	// @Pattern(regexp = "[\\d]{2}[.,][\\d]{3}[.,][\\d]{3}[-][A-Z]{1}")
	@RegexId
	private String id;

	// @NotEmpty
	private String name;

	// @NotBlank
	@Required
	private String surname;

	@NotBlank
	@Size(min = 3, max = 8)
	private String username;

	@NotBlank
	private String password;
	
	@NotBlank
	@Email
	private String email;

	@NotNull
	@Min(5)
	@Max(5000)
	private Integer account;

	@NotNull
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private Date birth;

	@NotNull
	private Country country;

	@NotEmpty
	private List<Role> roles;

	private Boolean enabled;

	@NotEmpty
	private String gender;

	private String secretValue;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSecretValue() {
		return secretValue;
	}

	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}
	
	
}
