package nl.mad.oehoe.command;

import java.io.IOException;

import nl.mad.oehoe.model.Contact;

import org.junit.Before;
import org.junit.Test;

//@formatter:off

public class PostContactsCommandImplTest extends BaseCommandTest {

    private Contact contact;
    @Before
    public void setup() throws IOException {
        super.setup();
        contact = createContact();  
    }
    
    private Contact createContact(){
        contact = new Contact();
        contact.setFirstName("Bert");
        contact.setLastName("Henk");
        contact.setBackGround("Is a special man");
        contact.setImageUrl("http://testimage.com/newimage");
        return contact;
    }
    
    @Test
    public void PostContactTest() throws IllegalStateException, IOException {
        setStatusLineCode(201);
        account.getContactsCommandFactory().createPostContactsCommand(contact).call();
        verifyUrl("https://test-url.com/Contacts");
        verifyHeader("Authorization", "Basic a2V5");
        verifyHeader("Content-Type", "application/json");
        verifyStatusLineCode(201);
        verifyHttpRequestMethod("POST");
        verifyContent(new String[] {"Bert", "Henk", "special", "newimage"});
    }
    
}
