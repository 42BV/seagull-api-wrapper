package nl.tweeenveertig.seagull.command.organisation;

import java.io.IOException;

import nl.tweeenveertig.seagull.command.BaseCommandTest;

import org.junit.Before;
import org.junit.Test;

public class DeleteOrganisationsCommandImplTest extends BaseCommandTest {

    @Before
    public void setup() throws IOException {
        super.setup();
    }

    @Test
    public void deleteOrganisationTest() throws IOException {
        setStatusLineCode(202);
        account.getOrganisationsCommandFactory().createDeleteOrganisationsCommand(123456789).call();
        verifyUrl("https://test-url.com/Organisations/123456789");
        verifyHeader("Authorization", "Basic a2V5");
        verifyStatusLineCode(202);
        verifyHttpRequestMethod("DELETE");
    }

}
