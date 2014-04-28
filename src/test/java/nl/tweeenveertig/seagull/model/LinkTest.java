package nl.tweeenveertig.seagull.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LinkTest {

    @Test
    public void constructLink() {
        Link link = new Link();
        link.setContactId(12);
        link.setDetails("Details");
        link.setLinkId(1);
        link.setOpportunityId(300);
        link.setOrganisationId(200);
        link.setProjectId(100);
        link.setRole("CEO");
        link.setSecondOpportunityId(301);
        link.setSecondProjectId(101);

        assertEquals("Contact is not the same, ", 12, link.getContactId());
        assertEquals("Details is not the same, ", "Details", link.getDetails());
        assertEquals("Link is not the same, ", 1, link.getLinkId());
        assertEquals("Opportunity is not the same, ", 300, link.getOpportunityId());
        assertEquals("Organisation is not the same, ", 200, link.getOrganisationId());
        assertEquals("Project is not the same, ", 100, link.getProjectId());
        assertEquals("Role is not the same, ", "CEO", link.getRole());
        assertEquals("Second opportunity is not the same, ", 301, link.getSecondOpportunityId());
        assertEquals("Second project is not the same, ", 101, link.getSecondProjectId());
    }

}
