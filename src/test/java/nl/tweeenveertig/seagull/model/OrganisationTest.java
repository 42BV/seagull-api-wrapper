package nl.tweeenveertig.seagull.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrganisationTest {

    @Test
    public void constructOrganisation() {

        Organisation organisation = new Organisation();
        organisation.setOrganisationId(123L);
        organisation.setOrganisationName("Test company");

        assertEquals("Id is not the same, ", new Long(123), organisation.getOrganisationId());
        assertEquals("Name is not the same, ", "Test company", organisation.getOrganisationName());

    }
}
