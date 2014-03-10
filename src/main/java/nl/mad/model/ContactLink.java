package nl.mad.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactLink {
    @JsonProperty("CONTACT_LINK_ID")
    private int contactLinkId;
    @JsonProperty("FIRST_CONTACT_ID")
    private int firstContactId;
    @JsonProperty("SECOND_CONTACT_ID")
    private int secondContactId;
    @JsonProperty("RELATIONSHIP_ID")
    private int relationshipId;
    @JsonProperty("DETAILS")
    private String details;

    public int getContactLinkId() {
        return contactLinkId;
    }

    public void setContactLinkId(int contactLinkId) {
        this.contactLinkId = contactLinkId;
    }

    public int getFirstContactId() {
        return firstContactId;
    }

    public void setFirstContactId(int firstContactId) {
        this.firstContactId = firstContactId;
    }

    public int getSecondContactId() {
        return secondContactId;
    }

    public void setSecondContactId(int secondContactId) {
        this.secondContactId = secondContactId;
    }

    public int getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(int relationshipId) {
        this.relationshipId = relationshipId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ContactLink [contactLinkId=" + contactLinkId + ", firstContactId=" + firstContactId + ", secondContactId=" + secondContactId
                + ", relationshipId=" + relationshipId + ", details=" + details + "]";
    }

}
