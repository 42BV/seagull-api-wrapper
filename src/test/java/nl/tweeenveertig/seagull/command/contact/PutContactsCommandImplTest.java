package nl.tweeenveertig.seagull.command.contact;

import java.io.IOException;

import nl.tweeenveertig.seagull.command.BaseCommandTest;
import nl.tweeenveertig.seagull.model.Contact;

import org.junit.Before;
import org.junit.Test;

public class PutContactsCommandImplTest extends BaseCommandTest {

    private Contact contact;

    @Before
    public void setup() throws IOException {
        super.setup();
        contact = createContact();
    }

    private Contact createContact() {
        contact = new Contact();
        contact.setFirstName("Bert");
        contact.setLastName("Henk");
        contact.setBackGround("Is a special man");
        contact.setImageUrl("http://testimage.com/newimage");
        return contact;
    }

    @Test
    public void PostContactTest() throws IllegalStateException, IOException {
        setStatusLineCode(200);
        account.getContactsCommandFactory().createPutContactsCommand(contact).call();
        verifyUrl("https://test-url.com/Contacts");
        verifyHeader("Authorization", "Basic a2V5");
        verifyHeader("Content-Type", "application/json");
        verifyStatusLineCode(200);
        verifyHttpRequestMethod("PUT");
        verifyContent(new String[] { "Bert", "Henk", "special", "newimage" });
    }

}
