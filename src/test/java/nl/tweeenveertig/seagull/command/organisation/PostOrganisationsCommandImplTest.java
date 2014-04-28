package nl.tweeenveertig.seagull.command.organisation;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import mockit.Expectations;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import nl.tweeenveertig.seagull.command.BaseCommandTest;
import nl.tweeenveertig.seagull.model.Organisation;

import org.apache.http.entity.StringEntity;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class PostOrganisationsCommandImplTest extends BaseCommandTest {

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
    public void PostOrganisationTest() throws IllegalStateException, IOException {
        setStatusLineCode(201);
        account.getOrganisationsCommandFactory().createPostOrganisationsCommand(organisation).call();
        verifyUrl("https://test-url.com/Organisations");
        verifyHeader("Authorization", "Basic a2V5");
        verifyHeader("Content-Type", "application/json");
        verifyStatusLineCode(201);
        verifyHttpRequestMethod("POST");
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
        account.getOrganisationsCommandFactory().createPostOrganisationsCommand(organisation).call();
        verifyStatusLineCode(400);
    }

    @Test
    public void createJsonProcessingException(@Mocked(stubOutClassInitialization = false) final ObjectMapper objectMapper) throws IOException {
        new NonStrictExpectations() {
            ObjectWriter objectWriter;
            {
                objectMapper.writer();
                result = objectWriter;
                objectWriter.writeValueAsString(any);
                result = new JsonGenerationException("Test");
            }
        };
        setStatusLineCode(400);
        account.getOrganisationsCommandFactory().createPostOrganisationsCommand(organisation).call();
        verifyStatusLineCode(400);
    }

}
