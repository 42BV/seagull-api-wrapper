package nl.mad.oehoe.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import mockit.NonStrictExpectations;
import nl.mad.oehoe.model.Contact;

import org.junit.Before;
import org.junit.Test;

//@formatter:off
public class GetContactsCommandImplTest extends BaseCommandTest {

    private final int listSize = 3;

    @Before
    public void setup() throws IOException {
        super.setup();
    }

    @Test
    public void getAllContactsTest() {
        List<Contact> contacts = account.getContactsCommandFactory().createGetContactsCommand().call();
        assertNotNull("The list should not be null, ", contacts);
        assertEquals("The list size does not match, ", listSize, contacts.size());
    }

    /**
     * This test causes an IOException at the parsing of json to java object, because the .json file has an error in it.
     * @throws IOException The exception
     */
    @Test()
    public void faultyGetAllContactsTest() throws IOException {
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("json-test-sample-faulty.json");
        new NonStrictExpectations() {
            {
                httpEntity.getContent(); result = inputStream;
            }
        };

        account.getContactsCommandFactory().createGetContactsCommand().call();
    }
}
