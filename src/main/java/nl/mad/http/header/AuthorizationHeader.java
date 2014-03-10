package nl.mad.http.header;

public class AuthorizationHeader extends AbstractHeader {
    private final String NAME = "Authorization";
    private final String BASIC = "Basic ";
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
