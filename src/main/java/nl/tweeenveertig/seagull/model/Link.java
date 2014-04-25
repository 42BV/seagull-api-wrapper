package nl.tweeenveertig.seagull.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Link is responsible for coupling an organisation with a contact.
 * @author Ruben Zorgman
 */
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

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(int opportunityId) {
        this.opportunityId = opportunityId;
    }

    public int getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(int organisationId) {
        this.organisationId = organisationId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getSecondProjectId() {
        return secondProjectId;
    }

    public void setSecondProjectId(int secondProjectId) {
        this.secondProjectId = secondProjectId;
    }

    public int getSecondOpportunityId() {
        return secondOpportunityId;
    }

    public void setSecondOpportunityId(int secondOpportunityId) {
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
