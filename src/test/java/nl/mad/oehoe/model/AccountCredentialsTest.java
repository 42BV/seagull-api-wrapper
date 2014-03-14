package nl.mad.oehoe.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import nl.mad.oehoe.model.AccountCredentials;

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
        accountCredentials = new AccountCredentials("test123");
        assertNotNull("Account credentials should not be null, ", accountCredentials);
    }

    @Test
    public void testUrl() {
        assertEquals("The url is not set correctly, ", "https://api.insight.ly/v2.1/", accountCredentials.getUrl());
    }

    @Test
    public void testApiKey() {
        assertEquals("The API key is not set correctly, ", "test123", accountCredentials.getApiKey());
    }

    /**
     * The following string has been converted to base64: "test123".
     * It was online converted using the following website: http://www.base64decode.org/
     */
    @Test
    public void testBase64Key() {
        String base64 = "dGVzdDEyMw==";
        assertEquals("The base64 key was not converted correctly, ", base64, accountCredentials.getBase64ApiKey());

    }

}
