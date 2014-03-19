package nl.mad.oehoe.header;

import mockit.Mocked;
import mockit.Verifications;

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
