package nl.tweeenveertig.seagull.command.organisation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import mockit.NonStrictExpectations;
import nl.tweeenveertig.seagull.command.BaseCommandTest;
import nl.tweeenveertig.seagull.model.Organisation;

import org.apache.http.client.methods.HttpRequestBase;
import org.junit.Before;
import org.junit.Test;

public class GetOrganisationsCommandImplTest extends BaseCommandTest {

    @Before
    public void setup() throws IOException {
        super.setup();
    }

    @Test
    public void getOrganisationTest() throws IOException {
        setStatusLineCode(200);
        loadJsonSample("");
        account.getOrganisationsCommandFactory().createGetOrganisationsCommand().call();
        verifyUrl("https://test-url.com/Organisations");
        verifyHeader("Authorization", "Basic a2V5");
        verifyHeader("Accept", "application/json");
        verifyStatusLineCode(200);
        verifyHttpRequestMethod("GET");
    }

    @Test
    public void getAllOrganisationsTest() throws IOException {
        setStatusLineCode(200);
        loadJsonSample("organisation-test-sample.json");
        List<Organisation> organisations = account.getOrganisationsCommandFactory().createGetOrganisationsCommand().call();
        assertNotNull("The list should not be null, ", organisations);
        assertEquals("The list size does not match, ", 2, organisations.size());
    }

    @Test
    public void faultyGetAllOrganisationsTest() throws IOException {
        setStatusLineCode(200);
        loadJsonSample("organisation-test-sample-faulty.json");
        account.getOrganisationsCommandFactory().createGetOrganisationsCommand().call();
    }

    @Test
    public void createRetryCallException() throws IOException {
        new NonStrictExpectations() {
            {
                httpClient.execute((HttpRequestBase) any);
                result = new IOException();
            }
        };
        account.getOrganisationsCommandFactory().createGetOrganisationsCommand().call();
    }

}
