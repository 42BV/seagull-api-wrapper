package nl.tweeenveertig.seagull.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains the information about a person.
 * @author Ruben Zorgman
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact extends AbstractEntity {
    @JsonProperty("CONTACT_ID")
    private Long contactId;
    @JsonProperty("SALUTATION")
    private String salutation;
    @JsonProperty("FIRST_NAME")
    private String firstName;
    @JsonProperty("LAST_NAME")
    private String lastName;

    @JsonProperty("DEFAULT_LINKED_ORGANISATION")
    private int defaultLinkedOrganisation;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDefaultLinkedOrganisation() {
        return defaultLinkedOrganisation;
    }

    public void setDefaultLinkedOrganisation(int defaultLinkedOrganisation) {
        this.defaultLinkedOrganisation = defaultLinkedOrganisation;
    }

}
