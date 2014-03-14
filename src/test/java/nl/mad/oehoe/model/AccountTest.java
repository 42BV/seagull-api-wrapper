package nl.mad.oehoe.model;

import static org.junit.Assert.assertNotNull;
import nl.mad.oehoe.model.Account;
import nl.mad.oehoe.model.AccountCredentials;

import org.junit.Before;

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
        assertNotNull("Account credenials should not be null, ", accountCredentials);
        assertNotNull("Account should not be null, ", account);
    }

}
