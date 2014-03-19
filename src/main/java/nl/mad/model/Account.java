package nl.mad.model;

import nl.mad.command.base.factory.ContactsCommandFactory;
import nl.mad.command.impl.factory.ContactsCommandFactoryImpl;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 *Account is the starting point of the API. From here you can call the CommandFactory.
 *It also creates and manages a CloseableHttpClient.
 *@author Ruben Zorgman
 */
public class Account {

    private AccountCredentials accountCredentials;
    private CloseableHttpClient httpClient;
    private static final int MAX_CONNECTIONS = 100;

    /**
     * Creates a new instance of Account, along with the account credentials that are set by the user.
     * @param accountCredentials The credentials for an account.
     */
    public Account(AccountCredentials accountCredentials) {
        this.accountCredentials = accountCredentials;
    }

    public AccountCredentials getAccountCredentials() {
        return accountCredentials;
    }

    public ContactsCommandFactory getContactsCommandFactory() {
        return new ContactsCommandFactoryImpl(this);
    }

    public void setHttpClient(CloseableHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * Gets the HttpClient if one exists, else it will make a new one.
     * @return The httpClient.
     */
    public CloseableHttpClient getHttpClient() {

        if (httpClient == null) {
            return createHttpClient();
        } else {
            return httpClient;
        }
    }

    private CloseableHttpClient createHttpClient() {
        httpClient = HttpClients.custom().setConnectionManager(createConnectionManager()).build();
        return httpClient;
    }

    private PoolingHttpClientConnectionManager createConnectionManager() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(MAX_CONNECTIONS);
        connectionManager.setDefaultMaxPerRoute(MAX_CONNECTIONS);
        return connectionManager;
    }

}
