package nl.mad.header;

/**
 * AuthorizationHeader is the implementation for an Authorization HTTP header. 
 * It tells the server the authentication credentials for HTTP authentication. 
 * This implementation uses basic authentication.
 * @author Ruben Zorgman
 */
public class AuthorizationHeader extends AbstractHeader {
    private static final String NAME = "Authorization";
    private static final String BASIC = "Basic ";
    private String value;

    /**
     * Creates an instance of AuthorizationHeader.
     * @param value The value for the AuthorizationHeader
     */
    public AuthorizationHeader(String value) {
        super(value);
        this.value = value;
    }

    @Override
    public String getHeaderName() {
        return NAME;
    }

    @Override
    public String getHeaderValue() {
        return BASIC + value;
    }

}
