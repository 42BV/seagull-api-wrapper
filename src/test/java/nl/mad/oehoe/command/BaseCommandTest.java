package nl.mad.oehoe.command;

import java.io.IOException;
import java.io.InputStream;

import mockit.Injectable;
import mockit.NonStrictExpectations;
import nl.mad.oehoe.model.Account;
import nl.mad.oehoe.model.AccountCredentials;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Before;

//@formatter:off
public abstract class BaseCommandTest {

    @Injectable
    protected CloseableHttpResponse response;
    
    @Injectable
    protected CloseableHttpClient httpClient;

    @Injectable
    protected HttpEntity httpEntity;
    
    @Injectable
    protected StatusLine statusLine;

    protected Account account;

    @Before
    public void setup() throws IOException {
        account = new Account(new AccountCredentials("key", "https://test-u-r-l.com/"));
        account.setHttpClient(httpClient);
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream("json-test-sample.json");
        new NonStrictExpectations() {
            {
                response.getEntity(); result = httpEntity;
                httpEntity.getContent(); result = inputStream;
                statusLine.getStatusCode(); result = 200;
                response.getStatusLine(); result = statusLine;
                httpClient.execute((HttpRequestBase)any); result = response;
            }
        };
    }
    
    /**
     * Set the StatusCode for a StatusLine.
     * @param statusLineCode The StatusCode
     */
    protected void setStatusLineCode(final int statusLineCode){
        new NonStrictExpectations() {
            {
                statusLine.getStatusCode(); result = statusLineCode;
            }
        };
        
    }

}
