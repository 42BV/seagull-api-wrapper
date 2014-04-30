package nl.tweeenveertig.seagull.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Link is responsible for coupling an organisation with a contact.
 * @author Ruben Zorgman
 */
public class Link {

    @JsonProperty("LINK_ID")
    private Long linkId;
    @JsonProperty("CONTACT_ID")
    private Long contactId;
    @JsonProperty("OPPORTUNITY_ID")
    private Long opportunityId;
    @JsonProperty("ORGANISATION_ID")
    private Long organisationId;
    @JsonProperty("PROJECT_ID")
    private Long projectId;
    @JsonProperty("SECOND_PROJECT_ID")
    private Long secondProjectId;
    @JsonProperty("SECOND_OPPORTUNITY_ID")
    private Long secondOpportunityId;
    @JsonProperty("ROLE")
    private String role;
    @JsonProperty("DETAILS")
    private String details;

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Long getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(Long opportunityId) {
        this.opportunityId = opportunityId;
    }

    public Long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(Long organisationId) {
        this.organisationId = organisationId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getSecondProjectId() {
        return secondProjectId;
    }

    public void setSecondProjectId(Long secondProjectId) {
        this.secondProjectId = secondProjectId;
    }

    public Long getSecondOpportunityId() {
        return secondOpportunityId;
    }

    public void setSecondOpportunityId(Long secondOpportunityId) {
        this.secondOpportunityId = secondOpportunityId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
