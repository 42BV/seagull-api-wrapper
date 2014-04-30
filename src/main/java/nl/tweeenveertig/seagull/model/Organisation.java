package nl.tweeenveertig.seagull.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains the information about an organisation.
 * @author Ruben Zorgman
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Organisation extends AbstractEntity {

    @JsonProperty("ORGANISATION_ID")
    private Long organisationId;

    @JsonProperty("ORGANISATION_NAME")
    private String organisationName;

    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

}
