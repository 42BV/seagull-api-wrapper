package nl.tweeenveertig.seagull.command.organisation;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import mockit.Expectations;
import mockit.Mocked;
import nl.tweeenveertig.seagull.command.BaseCommandTest;
import nl.tweeenveertig.seagull.model.Organisation;

import org.apache.http.entity.StringEntity;
import org.junit.Before;
import org.junit.Test;

public class PutOrganisationsCommandImplTest extends BaseCommandTest {

    private Organisation organisation;

    @Before
    public void setup() throws IOException {
        super.setup();
        organisation = createOrganisation();
    }

    private Organisation createOrganisation() {
        organisation = new Organisation();
        organisation.setBackGround("Background");
        organisation.setOrganisationName("Company");
        return organisation;
    }

    @Test
    public void putOrganisationsTest() throws IllegalStateException, IOException {
        setStatusLineCode(200);
        account.getOrganisationsCommandFactory().createPutOrganisationsCommand(organisation).call();
        verifyUrl("https://test-url.com/Organisations");
        verifyHeader("Authorization", "Basic a2V5");
        verifyHeader("Content-Type", "application/json");
        verifyStatusLineCode(200);
        verifyHttpRequestMethod("PUT");
        verifyContent(new String[] { "Background", "Company" });
    }

    @Test
    public void createUnsupportedEncodingException(@Mocked(stubOutClassInitialization = false) StringEntity unused) throws Exception {
        new Expectations() {
            {
                new StringEntity(anyString);
                result = new UnsupportedEncodingException();
            }
        };
        setStatusLineCode(400);
        account.getOrganisationsCommandFactory().createPutOrganisationsCommand(organisation).call();
        verifyStatusLineCode(400);
    }

}
