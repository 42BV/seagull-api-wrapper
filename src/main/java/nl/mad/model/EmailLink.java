package nl.mad.model;

public class EmailLink {

    private int emailLinkId;
    private int emailid;
    private int contactId;
    private int organisationId;
    private int opportunityId;
    private int projectId;

    public int getEmailLinkId() {
        return emailLinkId;
    }

    public void setEmailLinkId(int emailLinkId) {
        this.emailLinkId = emailLinkId;
    }

    public int getEmailid() {
        return emailid;
    }

    public void setEmailid(int emailid) {
        this.emailid = emailid;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(int organisationId) {
        this.organisationId = organisationId;
    }

    public int getOpportunityId() {
        return opportunityId;
    }

    public void setOpportunityId(int opportunityId) {
        this.opportunityId = opportunityId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "EmailLink [emailLinkId=" + emailLinkId + ", emailid=" + emailid + ", contactId=" + contactId + ", organisationId=" + organisationId
                + ", opportunityId=" + opportunityId + ", projectId=" + projectId + "]";
    }

}
