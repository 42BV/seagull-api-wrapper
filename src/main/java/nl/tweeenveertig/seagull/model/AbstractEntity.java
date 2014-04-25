package nl.tweeenveertig.seagull.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AbstactEntity has some shared attributes for Contact and Organisation
 * @author Ruben Zorgman
 */
public class AbstractEntity {

    @JsonProperty("BACKGROUND")
    private String backGround;
    @JsonProperty("IMAGE_URL")
    private String imageUrl;
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
    @JsonProperty("LINKS")
    private List<Link> links;

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

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

}
