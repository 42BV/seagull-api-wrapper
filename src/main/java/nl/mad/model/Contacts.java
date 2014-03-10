package nl.mad.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contacts {
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
    @JsonProperty("VISIBLE_TO")
    private String visibleTo;
    @JsonProperty("VISIBLE_TEAM_ID")
    private int visibleTeamId;
    @JsonProperty("VISIBLE_USER_IDS")
    private String visibleUserIds;
    @JsonProperty("CUSTOMFIELDS")
    private List<CustomField> customFields;
    @JsonProperty("ADDRESSES")
    private List<Address> addresses;
    @JsonProperty("CONTACTINFOS")
    private List<ContactInfo> contactInfos;
    @JsonProperty("DATES")
    private List<ContactDate> dates;
    @JsonProperty("TAGS")
    private List<Tag> tags;
    @JsonProperty("LINKS")
    private List<Link> links;
    @JsonProperty("CONTACTLINKS")
    private List<ContactLink> contactLinks;
    @JsonProperty("EMAILLINKS")
    private List<EmailLink> emailLinks;

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

    public String getVisibleTo() {
        return visibleTo;
    }

    public void setVisibleTo(String visibleTo) {
        this.visibleTo = visibleTo;
    }

    public int getVisibleTeamId() {
        return visibleTeamId;
    }

    public void setVisibleTeamId(int visibleTeamId) {
        this.visibleTeamId = visibleTeamId;
    }

    public String getVisibleUserIds() {
        return visibleUserIds;
    }

    public void setVisibleUserIds(String visibleUserIds) {
        this.visibleUserIds = visibleUserIds;
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

    public List<ContactDate> getDates() {
        return dates;
    }

    public void setDates(List<ContactDate> dates) {
        this.dates = dates;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public List<ContactLink> getContactLinks() {
        return contactLinks;
    }

    public void setContactLinks(List<ContactLink> contactLinks) {
        this.contactLinks = contactLinks;
    }

    public List<EmailLink> getEmailLinks() {
        return emailLinks;
    }

    public void setEmailLinks(List<EmailLink> emailLinks) {
        this.emailLinks = emailLinks;
    }

    @Override
    public String toString() {
        return "Contacts [contactId=" + contactId + ", salutation=" + salutation + ", firstName=" + firstName + ", lastName=" + lastName + ", backGround="
                + backGround + ", imageUrl=" + imageUrl + ", defaultLinkedOrganisation=" + defaultLinkedOrganisation + ", dateCreatedUtc=" + dateCreatedUtc
                + ", dateUpdatedUtc=" + dateUpdatedUtc + ", visibleTo=" + visibleTo + ", visibleTeamId=" + visibleTeamId + ", visibleUserIds=" + visibleUserIds
                + ", customFields=" + customFields + ", addresses=" + addresses + ", contactInfos=" + contactInfos + ", dates=" + dates + ", tags=" + tags
                + ", links=" + links + ", contactLinks=" + contactLinks + ", emailLinks=" + emailLinks + "]";
    }

}
