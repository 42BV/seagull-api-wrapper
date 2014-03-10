package nl.mad.http.header;

public class AcceptHeader extends AbstractHeader {
    private static final String NAME = "Accept";

    public AcceptHeader(String value) {
        super(value);
    }

    @Override
    public String getHeaderName() {
        return NAME;
    }
}
