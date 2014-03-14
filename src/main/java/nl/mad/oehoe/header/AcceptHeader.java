package nl.mad.oehoe.header;

/**
 * AcceptHeader is the header implementation for an Accept HTTP header.
 * It tells the server which Content-Types are acceptable for the response
 * @author Ruben Zorgman
 */
public class AcceptHeader extends AbstractHeader {
    private static final String NAME = "Accept";

    /**
     * Creates an instance of Acceptheader.
     * @param value The value for the AcceptHeader
     */
    public AcceptHeader(String value) {
        super(value);
    }

    @Override
    public String getHeaderName() {
        return NAME;
    }
}
