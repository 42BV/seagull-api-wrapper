package nl.tweeenveertig.seagull.header;

import org.junit.Test;

public class AcceptHeaderTest extends AbstractHeaderTest {

    @Test
    public void testAddHeader() {
        testHeader(new AcceptHeader("application/json"));
    }

}
