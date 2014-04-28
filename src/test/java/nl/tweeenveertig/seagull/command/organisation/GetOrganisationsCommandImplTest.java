package nl.tweeenveertig.seagull.command.organisation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import nl.tweeenveertig.seagull.command.BaseCommandTest;
import nl.tweeenveertig.seagull.model.Contact;

import org.junit.Before;
import org.junit.Test;

public class GetOrganisationsCommandImplTest extends BaseCommandTest {

    @Before
    public void setup() throws IOException {
        super.setup();
    }

    @Test
    public void getOrganisationTest() throws IOException {
        setStatusLineCode(200);
        loadJsonSample("json-test-sample.json");
        account.getContactsCommandFactory().createGetContactsCommand().call();
        verifyUrl("https://test-url.com/Contacts");
        verifyHeader("Authorization", "Basic a2V5");
        verifyHeader("Accept", "application/json");
        verifyStatusLineCode(200);
        verifyHttpRequestMethod("GET");
    }

    @Test
    public void getAllContactsTest() throws IOException {
        setStatusLineCode(200);
        loadJsonSample("json-test-sample.json");
        List<Contact> contacts = account.getContactsCommandFactory().createGetContactsCommand().call();
        assertNotNull("The list should not be null, ", contacts);
        assertEquals("The list size does not match, ", 3, contacts.size());
    }

    @Test
    public void faultyGetAllContactsTest() throws IOException {
        setStatusLineCode(200);
        loadJsonSample("json-test-sample-faulty.json");
        account.getContactsCommandFactory().createGetContactsCommand().call();
    }

}
