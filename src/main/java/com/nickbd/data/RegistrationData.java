package com.nickbd.data;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class RegistrationData implements Writable {
	private Text registrationId = new Text();
	private Text emailAddress = new Text();
	private Text age = new Text();
	private Text gender = new Text();
	private Text city = new Text();
	private Text state = new Text();
	private Text country = new Text();
	private Text zipCode = new Text();
	private Text minIncomeLevel = new Text();
	private Text maxIncomeLevel = new Text();
	private Text educationLevel = new Text();
	
	
	public RegistrationData() {
	}
	
	
	
	
	public void set(String registrationId,
					String emailAddress,
					String age,
					String gender,
					String city,
					String state,
					String country,
					String zipCode,
					String minIncomeLevel,
					String maxIncomeLevel,
					String educationLevel) {
		
		this.registrationId.set(registrationId);
		this.emailAddress.set(emailAddress);
		this.age.set(age);
		this.gender.set(gender);
		this.city.set(city);
		this.state.set(state);
		this.country.set(country);
		this.zipCode.set(zipCode);
		this.minIncomeLevel.set(minIncomeLevel);
		this.maxIncomeLevel.set(maxIncomeLevel);
		this.educationLevel.set(educationLevel);		
		
		
	}
	
	  /** 
	   * Serialize the fields of this object to <code>out</code>.
	   * 
	   * @param out <code>DataOuput</code> to serialize this object into.
	   * @throws IOException
	   */
	public void write(DataOutput out) throws IOException {
		registrationId.write(out);
		emailAddress.write(out);
		age.write(out);
		gender.write(out);
		city.write(out);
		state.write(out);
		country.write(out);
		zipCode.write(out);
		minIncomeLevel.write(out);
		maxIncomeLevel.write(out);
		educationLevel.write(out);
	}


	  /** 
	   * Deserialize the fields of this object from <code>in</code>.  
	   * 
	   * <p>For efficiency, implementations should attempt to re-use storage in the 
	   * existing object where possible.</p>
	   * 
	   * @param in <code>DataInput</code> to deseriablize this object from.
	   * @throws IOException
	   */
	  public void readFields(DataInput in) throws IOException {
			registrationId.readFields(in);
			emailAddress.readFields(in);
			age.readFields(in);
			gender.readFields(in);
			city.readFields(in);
			state.readFields(in);
			country.readFields(in);
			zipCode.readFields(in);
			minIncomeLevel.readFields(in);
			maxIncomeLevel.readFields(in);
			educationLevel.readFields(in);
			
			
			
	  }
	
	public Text getRegistrationId() {
		return registrationId;
	}


	public void setRegistrationId(Text registrationId) {
		this.registrationId = registrationId;
	}


	public Text getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(Text emailAddress) {
		this.emailAddress = emailAddress;
	}


	public Text getAge() {
		return age;
	}


	public void setAge(Text age) {
		this.age = age;
	}


	public Text getGender() {
		return gender;
	}


	public void setGender(Text gender) {
		this.gender = gender;
	}


	public Text getCity() {
		return city;
	}


	public void setCity(Text city) {
		this.city = city;
	}


	public Text getState() {
		return state;
	}


	public void setState(Text state) {
		this.state = state;
	}


	public Text getCountry() {
		return country;
	}


	public void setCountry(Text country) {
		this.country = country;
	}


	public Text getZipCode() {
		return zipCode;
	}


	public void setZipCode(Text zipCode) {
		this.zipCode = zipCode;
	}


	public Text getMinIncomeLevel() {
		return minIncomeLevel;
	}

	public void setMinIncomeLevel(Text minIncomeLevel) {
		this.minIncomeLevel = minIncomeLevel;
	}


	public Text getMaxIncomeLevel() {
		return maxIncomeLevel;
	}


	public void setMaxIncomeLevel(Text maxIncomeLevel) {
		this.maxIncomeLevel = maxIncomeLevel;
	}


	public Text getEducationLevel() {
		return educationLevel;
	}


	public void setEducationLevel(Text educationLevel) {
		this.educationLevel = educationLevel;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((educationLevel == null) ? 0 : educationLevel.hashCode());
		result = prime * result
				+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result
				+ ((maxIncomeLevel == null) ? 0 : maxIncomeLevel.hashCode());
		result = prime * result
				+ ((minIncomeLevel == null) ? 0 : minIncomeLevel.hashCode());
		result = prime * result
				+ ((registrationId == null) ? 0 : registrationId.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistrationData other = (RegistrationData) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (educationLevel == null) {
			if (other.educationLevel != null)
				return false;
		} else if (!educationLevel.equals(other.educationLevel))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (maxIncomeLevel == null) {
			if (other.maxIncomeLevel != null)
				return false;
		} else if (!maxIncomeLevel.equals(other.maxIncomeLevel))
			return false;
		if (minIncomeLevel == null) {
			if (other.minIncomeLevel != null)
				return false;
		} else if (!minIncomeLevel.equals(other.minIncomeLevel))
			return false;
		if (registrationId == null) {
			if (other.registrationId != null)
				return false;
		} else if (!registrationId.equals(other.registrationId))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}




	

}