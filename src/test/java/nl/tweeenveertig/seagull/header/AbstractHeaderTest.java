package nl.tweeenveertig.seagull.header;

import mockit.Mocked;
import mockit.Verifications;
import nl.tweeenveertig.seagull.header.AbstractHeader;

import org.apache.http.client.methods.HttpRequestBase;

public abstract class AbstractHeaderTest {

    @Mocked
    private HttpRequestBase request;

    protected void testHeader(final AbstractHeader header) {
        header.setHeader(request);
        new Verifications() {
            {
                request.setHeader(header.getHeaderName(), header.getHeaderValue());
            }
        };
    }

}
