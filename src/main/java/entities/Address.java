package entities;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Id;

public class Address {

	@Id
	private ObjectId id;
	
	private String street;
	
	private String city;
	
	private String postCode;
	
	private String country;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString() {
		return street + " "+ postCode + " "+ city + " ("+ country +")"; 
	}
	
}
