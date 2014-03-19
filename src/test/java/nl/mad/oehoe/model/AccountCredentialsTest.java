package nl.mad.oehoe.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Account Credentials.
 * @author Ruben Zorgman
 *
 */
public class AccountCredentialsTest {

    private AccountCredentials accountCredentials;

    @Before
    public void setup() {
        accountCredentials = new AccountCredentials("test123", "https://test-url.com/");
        assertNotNull("Account credentials should not be null, ", accountCredentials);
    }

    @Test
    public void urlTest() {
        assertEquals("The url is not set correctly, ", "https://test-url.com/", accountCredentials.getUrl());
    }

    @Test
    public void apiKeyTest() {
        assertEquals("The API key is not set correctly, ", "test123", accountCredentials.getApiKey());
    }

    /**
     * The following string has been converted to base64: "test123".
     * It was online converted using the following website: http://www.base64decode.org/
     */
    @Test
    public void base64KeyTest() {
        String base64 = "dGVzdDEyMw==";
        assertEquals("The base64 key was not converted correctly, ", base64, accountCredentials.getBase64ApiKey());

    }

}
