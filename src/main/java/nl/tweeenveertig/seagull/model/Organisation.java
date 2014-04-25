package nl.tweeenveertig.seagull.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Organisation extends AbstractEntity {

    @JsonProperty("ORGANISATION_ID")
    private int organisationId;

    @JsonProperty("ORGANISATION_NAME")
    private String organisationName;

}
