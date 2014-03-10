package nl.mad.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactInfo {
    @JsonProperty("CONTACT_INFO_ID")
    private int contactInfoId;
    @JsonProperty("TYPE")
    private String type;
    @JsonProperty("SUBTYPE")
    private String subType;
    @JsonProperty("LABEL")
    private String label;
    @JsonProperty("DETAIL")
    private String detail;

}
