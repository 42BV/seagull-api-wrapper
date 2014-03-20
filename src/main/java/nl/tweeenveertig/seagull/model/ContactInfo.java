package nl.tweeenveertig.seagull.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains the information about a contact, such as telephone, or emailaddress.
 * @author Ruben Zorgman
 */
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

    public int getContactInfoId() {
        return contactInfoId;
    }

    public void setContactInfoId(int contactInfoId) {
        this.contactInfoId = contactInfoId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}
