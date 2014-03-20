package nl.tweeenveertig.seagull.command.contact;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import mockit.Expectations;
import mockit.Mocked;
import nl.tweeenveertig.seagull.command.BaseCommandTest;
import nl.tweeenveertig.seagull.model.Contact;

import org.apache.http.entity.StringEntity;
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
    
    @Test
    public void createUnsupportedEncodingException(@Mocked(stubOutClassInitialization = false) StringEntity unused) throws Exception {
        new Expectations() {
            {
                new StringEntity(anyString);
                result = new UnsupportedEncodingException();
            }
        };
        account.getContactsCommandFactory().createPostContactsCommand(contact).call();
    }
    
//    @Test
//    public void createJsonProcessingException(@Mocked(stubOutClassInitialization = false) final ObjectWriter unused) throws JsonProcessingException{
//        new Expectations() {
//            {
//                new PostContactsCommandImpl(account, contact).createObjectMapper();
//                result = new JsonGenerationException("Test"); 
//            }
//        };
//        account.getContactsCommandFactory().createPostContactsCommand(contact).call();
//    }
    
}
