package com.example.sample2app.model;


public class Address  {
    private  String addressid;
	private String street;
	private String city;
	private String state;
	

	public Address(String addressid,String street, String city, String state) {
		super();
		this.addressid = addressid;
		this.street = street;
		this.city = city;
		this.state = state;
		
	}
	public Address() {
		
	}
	

	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [addressid=" + addressid + ", street=" + street + ", city=" + city + ", state=" + state + "]";
	}
}