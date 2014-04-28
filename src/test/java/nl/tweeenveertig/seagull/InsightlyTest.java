package nl.tweeenveertig.seagull;

import java.io.IOException;
import java.util.List;

import mockit.Mocked;
import nl.tweeenveertig.seagull.command.BaseCommandTest;
import nl.tweeenveertig.seagull.model.Contact;
import nl.tweeenveertig.seagull.model.Organisation;

import org.apache.http.StatusLine;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsightlyTest extends BaseCommandTest {

    private Insightly insightly;

    @Mocked
    private StatusLine statusLine;

    @Before
    public void setup() throws IOException {
        super.setup();
        insightly = new Insightly("APIKEY", "https://testurl.com");
        insightly.setHttpClient(httpClient);
    }

    @Test
    public void getContactTest() throws IOException {
        setStatusLineCode(200);
        loadJsonSample("contact-test-sample.json");
        List<Contact> contacts = insightly.getContacts();
        Assert.assertEquals("Number of contacts does not match, ", 3, contacts.size());
    }

    @Test
    public void postContactTest() throws IOException {
        setStatusLineCode(201);
        insightly.createContact(createContact());
        verifyStatusLineCode(201);
        verifyHttpRequestMethod("POST");
        verifyContent(new String[] { "Bert", "Henk", "special" });
    }

    @Test
    public void putContactTest() throws IOException {
        setStatusLineCode(201);
        insightly.updateContact(createContact());
        verifyStatusLineCode(201);
        verifyHttpRequestMethod("PUT");
        verifyContent(new String[] { "Bert", "Henk", "special" });
    }

    @Test
    public void deleteContactTest() throws IOException {
        insightly.deleteContact(12364);
        verifyHttpRequestMethod("DELETE");
    }

    @Test
    public void getOrganisationTest() throws IOException {
        setStatusLineCode(200);
        loadJsonSample("organisation-test-sample.json");
        List<Organisation> organisations = insightly.getOrganisations();
        Assert.assertEquals("Number of organisations does not match, ", 2, organisations.size());
    }

    @Test
    public void postOrganisationTest() throws IOException {
        setStatusLineCode(201);
        insightly.createOrganisation(createOrganisation());
        verifyStatusLineCode(201);
        verifyHttpRequestMethod("POST");
        verifyContent(new String[] { "Background", "Company" });
    }

    @Test
    public void putOrganisationTest() throws IOException {
        setStatusLineCode(201);
        insightly.updateOrganisation(createOrganisation());
        verifyStatusLineCode(201);
        verifyHttpRequestMethod("PUT");
        verifyContent(new String[] { "Background", "Company" });
    }

    /**
     * This test also creates the Insightly object with only one argument.
     * @throws IOException
     */
    @Test
    public void deleteOrganisationTest() throws IOException {
        insightly = new Insightly("APIKEY");
        insightly.setHttpClient(httpClient);
        insightly.deleteOrganisation(12364);
        verifyHttpRequestMethod("DELETE");
    }

    private Contact createContact() {
        Contact contact = new Contact();
        contact.setFirstName("Bert");
        contact.setLastName("Henk");
        contact.setBackGround("Is a special man");
        return contact;
    }

    private Organisation createOrganisation() {
        Organisation organisation = new Organisation();
        organisation.setBackGround("Background");
        organisation.setOrganisationName("Company");
        return organisation;
    }

}
