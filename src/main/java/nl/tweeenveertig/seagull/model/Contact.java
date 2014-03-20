package nl.tweeenveertig.seagull.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains the information about a person.
 * @author Ruben Zorgman
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {
    @JsonProperty("CONTACT_ID")
    private int contactId;
    @JsonProperty("SALUTATION")
    private String salutation;
    @JsonProperty("FIRST_NAME")
    private String firstName;
    @JsonProperty("LAST_NAME")
    private String lastName;
    @JsonProperty("BACKGROUND")
    private String backGround;
    @JsonProperty("IMAGE_URL")
    private String imageUrl;
    @JsonProperty("DEFAULT_LINKED_ORGANISATION")
    private int defaultLinkedOrganisation;
    @JsonProperty("DATE_CREATED_UTC")
    private String dateCreatedUtc;
    @JsonProperty("DATE_UPDATED_UTC")
    private String dateUpdatedUtc;
    @JsonProperty("CUSTOMFIELDS")
    private List<CustomField> customFields;
    @JsonProperty("ADDRESSES")
    private List<Address> addresses;
    @JsonProperty("CONTACTINFOS")
    private List<ContactInfo> contactInfos;
    @JsonProperty("TAGS")
    private List<Tag> tags;
    @JsonProperty("CONTACTLINKS")
    private List<ContactLink> contactLinks;

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
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

    public String getBackGround() {
        return backGround;
    }

    public void setBackGround(String backGround) {
        this.backGround = backGround;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getDefaultLinkedOrganisation() {
        return defaultLinkedOrganisation;
    }

    public void setDefaultLinkedOrganisation(int defaultLinkedOrganisation) {
        this.defaultLinkedOrganisation = defaultLinkedOrganisation;
    }

    public String getDateCreatedUtc() {
        return dateCreatedUtc;
    }

    public void setDateCreatedUtc(String dateCreatedUtc) {
        this.dateCreatedUtc = dateCreatedUtc;
    }

    public String getDateUpdatedUtc() {
        return dateUpdatedUtc;
    }

    public void setDateUpdatedUtc(String dateUpdatedUtc) {
        this.dateUpdatedUtc = dateUpdatedUtc;
    }

    public List<CustomField> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<ContactInfo> getContactInfos() {
        return contactInfos;
    }

    public void setContactInfos(List<ContactInfo> contactInfos) {
        this.contactInfos = contactInfos;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<ContactLink> getContactLinks() {
        return contactLinks;
    }

    public void setContactLinks(List<ContactLink> contactLinks) {
        this.contactLinks = contactLinks;
    }

}
