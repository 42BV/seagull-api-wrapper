package nl.tweeenveertig.seagull.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains the address information.
 * @author Ruben Zorgman
 */
public class Address {
    @JsonProperty("ADDRESS_ID")
    private Long addressId;
    @JsonProperty("ADDRESS_TYPE")
    private String addressType;
    @JsonProperty("STREET")
    private String street;
    @JsonProperty("CITY")
    private String city;
    @JsonProperty("STATE")
    private String state;
    @JsonProperty("POSTCODE")
    private String postcode;
    @JsonProperty("COUNTRY")
    private String country;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
