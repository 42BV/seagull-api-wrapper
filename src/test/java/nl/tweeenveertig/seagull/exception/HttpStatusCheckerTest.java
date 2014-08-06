package nl.tweeenveertig.seagull.exception;

import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HttpStatusCheckerTest {

    @Mocked
    protected CloseableHttpResponse response;

    @Mocked
    protected StatusLine statusLine;

    public HttpStatusCheckerTest() {

    }

    @Before
    public void setup() {
        new NonStrictExpectations() {
            {
                response.getStatusLine();
                result = statusLine;

            }
        };

    }

    @Test
    public void rangeSpecificTest() {
        setStatusCode(401);
        Assert.assertTrue("String does not match ", catchExceptionMessage().contains("401"));
    }

    @Test
    public void range300Test() {
        setStatusCode(302);
        Assert.assertTrue("String does not match ", catchExceptionMessage().contains("302"));

    }

    @Test
    public void range400Test() {
        setStatusCode(412);
        Assert.assertTrue("String does not match ", catchExceptionMessage().contains("412"));

    }

    @Test
    public void range500Test() {
        setStatusCode(502);
        Assert.assertTrue("String does not match ", catchExceptionMessage().contains("502"));

    }

    private String catchExceptionMessage() {
        String exception = "";
        try {
            HttpStatusChecker.checkStatus(response);
        } catch (Exception e) {
            exception = e.getLocalizedMessage();
        }
        return exception;
    }

    private void setStatusCode(final int statusCode) {
        new NonStrictExpectations() {
            {
                statusLine.getStatusCode();
                result = statusCode;
            }
        };

    }
}
