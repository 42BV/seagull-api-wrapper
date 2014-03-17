package nl.mad.oehoe.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import mockit.Injectable;
import mockit.NonStrictExpectations;
import nl.mad.oehoe.command.impl.contacts.GetContactsCommandImpl;
import nl.mad.oehoe.model.Account;
import nl.mad.oehoe.model.AccountCredentials;
import nl.mad.oehoe.model.Contact;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Before;
import org.junit.Test;

public class AbstractGetCommandTest {

    private final int listSize = 3;

    @Injectable
    private CloseableHttpResponse response;

    @Injectable
    private HttpEntity httpEntity;

    private GetContactsCommandImpl getContacts;

    private InputStream inputStream;

    @Before
    public void setup() throws IOException {
        getContacts = new GetContactsCommandImpl(new Account(new AccountCredentials("key")));
        inputStream = ClassLoader.getSystemResourceAsStream("json-test-sample.json");
        new NonStrictExpectations() {
            {
                response.getEntity();
                result = httpEntity;
                httpEntity.getContent();
                result = inputStream;
            }
        };
    }

    @Test
    public void getAllContactsTest() {
        List<Contact> contacts = getContacts.getReturnObject(response);
        assertNotNull("The list should not be null, ", contacts);
        assertEquals("The list size does not match, ", listSize, contacts.size());
    }

}
