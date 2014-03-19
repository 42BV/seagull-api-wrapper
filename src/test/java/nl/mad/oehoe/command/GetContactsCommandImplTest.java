package nl.mad.oehoe.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import nl.mad.oehoe.model.Contact;

import org.junit.Before;
import org.junit.Test;

//@formatter:off
public class GetContactsCommandImplTest extends BaseCommandTest {

    @Before
    public void setup() throws IOException {
        super.setup();
    }

    @Test
    public void getAllContactsTest() throws IOException {
        loadJsonSample("json-test-sample.json");
        List<Contact> contacts = account.getContactsCommandFactory().createGetContactsCommand().call();
        assertNotNull("The list should not be null, ", contacts);
        assertEquals("The list size does not match, ", 3, contacts.size());
    }

    /**
     * This test causes an IOException when it is parsing json to a java object, because there is an error in the .json file.
     * @throws IOException The exception
     */
    @Test()
    public void faultyGetAllContactsTest() throws IOException {
        loadJsonSample("json-test-sample-faulty.json");
        account.getContactsCommandFactory().createGetContactsCommand().call();
    }
}
