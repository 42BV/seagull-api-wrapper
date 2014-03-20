package nl.tweeenveertig.seagull.command.contact;

import java.io.IOException;

import nl.tweeenveertig.seagull.command.BaseCommandTest;

import org.junit.Before;
import org.junit.Test;

public class DeleteContactsCommandImplTest extends BaseCommandTest {

    @Before
    public void setup() throws IOException {
        super.setup();
    }

    @Test
    public void deleteContactTest() throws IOException {
        setStatusLineCode(202);
        account.getContactsCommandFactory().createDeleteContactsCommand(123456789).call();
        verifyUrl("https://test-url.com/Contacts/123456789");
        verifyHeader("Authorization", "Basic a2V5");
        verifyStatusLineCode(202);
        verifyHttpRequestMethod("DELETE");
    }

}
