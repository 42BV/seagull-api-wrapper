package nl.tweeenveertig.seagull.header;

import org.junit.Test;

public class ContentTypeHeaderTest extends AbstractHeaderTest {

    @Test
    public void testAddHeader() {
        testHeader(new ContentTypeHeader("application/json"));
    }

}
