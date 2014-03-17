package nl.mad.oehoe.model;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Account.
 * @author Ruben Zorgman
 *
 */
public class AccountTest {

    private AccountCredentials accountCredentials;
    private Account account;

    @Before
    public void setup() {
        accountCredentials = new AccountCredentials("Key");
        account = new Account(accountCredentials);
    }

    @Test
    public void testContactsCommandFactory() {
        assertNotNull("Contacts Command Factory should not be null, ", account.getContactsCommandFactory());
    }

    @Test
    public void testAccountCredentials() {
        assertNotNull("Account credentials should not be null, ", account.getAccountCredentials());
    }

    @Test
    public void testHttpClient() {
        assertNotNull("The CloseableHttpClient should not be null, ", account.getHttpClient());
    }

}
