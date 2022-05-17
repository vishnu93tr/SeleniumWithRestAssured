package org.selenium.pom.objects;

public class BillingAddress {
    private String firstName;
    private String lastName;
    private String billingAddress;
    private String billingCity;
    private String billingPincode;
    private String billingEmail;
    private String country;
    private String state;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFirstName() {
        return firstName;
    }

    public BillingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BillingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public BillingAddress setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
        return this;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public BillingAddress setBillingCity(String billingCity) {
        this.billingCity = billingCity;
        return this;
    }

    public String getBillingPincode() {
        return billingPincode;
    }

    public BillingAddress setBillingPincode(String billingPincode) {
        this.billingPincode = billingPincode;
        return this;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public BillingAddress setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
        return this;
    }
}
