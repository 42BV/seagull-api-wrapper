package nl.mad.http.header;

public class AuthorizationHeader extends AbstractHeader {
    private static final String NAME = "Authorization";
    private static final String BASIC = "Basic ";
    private String value;

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
