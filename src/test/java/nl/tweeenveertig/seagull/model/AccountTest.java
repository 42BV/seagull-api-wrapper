package nl.tweeenveertig.seagull.model;

import static org.junit.Assert.assertNotNull;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.AccountCredentials;

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
        accountCredentials = new AccountCredentials("Key", "https://test-url.com/");
        account = new Account(accountCredentials);
    }

    @Test
    public void contactsCommandFactoryTest() {
        assertNotNull("Contacts Command Factory should not be null, ", account.getContactsCommandFactory());
    }

    @Test
    public void accountCredentialsTest() {
        assertNotNull("Account credentials should not be null, ", account.getAccountCredentials());
    }

    @Test
    public void httpClientTest() {
        assertNotNull("The CloseableHttpClient should not be null, ", account.getHttpClient());
    }

}
