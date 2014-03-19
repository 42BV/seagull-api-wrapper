package nl.mad.oehoe.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import mockit.Injectable;
import mockit.NonStrictExpectations;
import mockit.Verifications;
import nl.mad.oehoe.model.Account;
import nl.mad.oehoe.model.AccountCredentials;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
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
        account = new Account(new AccountCredentials("key", "https://test-url.com/"));
        account.setHttpClient(httpClient);
        new NonStrictExpectations() {
            {
                response.getEntity(); result = httpEntity;
                statusLine.getStatusCode(); result = 200;
                response.getStatusLine(); result = statusLine;
                httpClient.execute((HttpRequestBase)any); result = response;
            }
        };
    }
    
    protected void setStatusLineCode(final int statusLineCode){
        new NonStrictExpectations() {
            {
                statusLine.getStatusCode(); result = statusLineCode;
            }
        };
    }
    
    protected void loadJsonSample(String file) throws IOException{
        final InputStream inputStream = ClassLoader.getSystemResourceAsStream(file);
        new NonStrictExpectations() {
            {
                httpEntity.getContent(); result = inputStream;
            }
        };
    }
    
    protected String convertInputStreamToString(InputStream inputStream) throws IOException{
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream, writer);
        String string = writer.toString();
        return string;
    }
    
    protected void verifyHeader(final String headerName, final String expectedValue) throws IOException{
        new Verifications(){{
            HttpRequestBase request;
            httpClient.execute(request = withCapture());
            assertEquals("The header value is not the same, ", expectedValue, request.getFirstHeader(headerName).getValue());
            assertEquals("The header name is not the same, ", headerName, request.getFirstHeader(headerName).getName());
        }
        };
    }
    
    protected void verifyUrl(final String expectedUri) throws IOException{
        new Verifications(){{
            HttpRequestBase request;
            httpClient.execute(request = withCapture());
            assertEquals("The URL is not the same, ", expectedUri, request.getURI().toString());
        }
        };
    }
    
    protected void verifyStatusLineCode(final int statusLineCode) throws IOException{
        assertEquals("The status line code is not the same, ", statusLineCode, statusLine.getStatusCode());
    }
    
    protected void verifyHttpRequestMethod(final String requestMethod) throws IOException{
        new Verifications(){{
            HttpRequestBase request;
            httpClient.execute(request = withCapture());
            assertEquals("The request method is not the same, ", requestMethod, request.getMethod());
        }
        };                      
    }
    
    protected void verifyContent(final String[] expectedValues) throws IOException{
        new Verifications(){{
            HttpEntityEnclosingRequestBase request;
            httpClient.execute(request = withCapture());
            String content = convertInputStreamToString(request.getEntity().getContent());
            for(String string: expectedValues){
                assertTrue("The content does not contain the expected values, ", (content.contains(string)));
            }
        }
        };
    }
}
