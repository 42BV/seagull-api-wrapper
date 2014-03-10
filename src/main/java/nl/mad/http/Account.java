package nl.mad.http;

import nl.mad.client.CommandFactory;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Account {

    private AccountCredentials accountCredentials;
    private CloseableHttpClient httpClient;

    public Account(AccountCredentials accountCredentials) {
        this.accountCredentials = accountCredentials;
    }

    public AccountCredentials getAccountCredentials() {
        return accountCredentials;
    }

    public CommandFactory getCommandFactory() {
        return new CommandFactory(this);
    }

    public CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            return createHttpClient();
        } else {
            return httpClient;
        }
    }

    private CloseableHttpClient createHttpClient() {
        httpClient = HttpClients.custom().build();
        return httpClient;
    }

}
