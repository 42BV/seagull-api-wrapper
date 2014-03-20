package nl.tweeenveertig.seagull.header;

import org.junit.Test;

public class AuthorizationHeaderTest extends AbstractHeaderTest {

    @Test
    public void testAddHeader() {
        testHeader(new AuthorizationHeader("key"));
    }

}
