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

}
