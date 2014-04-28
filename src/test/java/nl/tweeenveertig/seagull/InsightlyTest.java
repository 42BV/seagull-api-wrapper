package nl.tweeenveertig.seagull;

import java.io.IOException;

import mockit.Mocked;
import mockit.NonStrictExpectations;
import nl.tweeenveertig.seagull.command.BaseCommandTest;

import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpRequestBase;
import org.junit.Before;

public class InsightlyTest extends BaseCommandTest {

    private Insightly insightly;

    @Mocked
    private StatusLine statusLine;

    @Before
    public void setup() throws IOException {
        super.setup();
        new NonStrictExpectations() {
            {
                response.getEntity();
                result = httpEntity;

                response.getStatusLine();
                result = statusLine;
                httpClient.execute((HttpRequestBase) any);
                result = response;
            }
        };
        insightly = new Insightly("ApiKey");

    }

}
