package nl.tweeenveertig.seagull.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkTest {

    @Test
    public void constructLink() {
        Link link = new Link();
        link.setContactId(12L);
        link.setDetails("Details");
        link.setLinkId(1L);
        link.setOpportunityId(300L);
        link.setOrganisationId(200L);
        link.setProjectId(100L);
        link.setRole("CEO");
        link.setSecondOpportunityId(301L);
        link.setSecondProjectId(101L);

        assertEquals("Contact is not the same, ", new Long(12), link.getContactId());
        assertEquals("Details is not the same, ", "Details", link.getDetails());
        assertEquals("Link is not the same, ", new Long(1), link.getLinkId());
        assertEquals("Opportunity is not the same, ", new Long(300), link.getOpportunityId());
        assertEquals("Organisation is not the same, ", new Long(200), link.getOrganisationId());
        assertEquals("Project is not the same, ", new Long(100), link.getProjectId());
        assertEquals("Role is not the same, ", "CEO", link.getRole());
        assertEquals("Second opportunity is not the same, ", new Long(301), link.getSecondOpportunityId());
        assertEquals("Second project is not the same, ", new Long(101), link.getSecondProjectId());
    }

}
