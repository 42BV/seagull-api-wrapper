package nl.mad.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Link {
    @JsonProperty("LINK_ID")
    private int linkId;
    @JsonProperty("CONTACT_ID")
    private int contactId;
    @JsonProperty("OPPORTUNITY_ID")
    private int opportunityId;
    @JsonProperty("ORGANISATION_ID")
    private int organisationId;
    @JsonProperty("PROJECT_ID")
    private int projectId;
    @JsonProperty("SECOND_PROJECT_ID")
    private int secondProjectId;
    @JsonProperty("SECOND_OPPORTUNITY_ID")
    private int secondOpportunityId;
    @JsonProperty("ROLE")
    private String role;
    @JsonProperty("DETAILS")
    private String details;

}
