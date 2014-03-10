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

    @Override
    public String toString() {
        return "ContactInfo [contactInfoId=" + contactInfoId + ", type=" + type + ", subType=" + subType + ", label=" + label + ", detail=" + detail + "]";
    }

}
