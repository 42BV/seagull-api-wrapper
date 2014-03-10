package nl.mad.http.header;

public class ContentTypeHeader extends AbstractHeader {

    private final String NAME = "Content-Type";

    public ContentTypeHeader(String value) {
        super(value);
    }

    @Override
    public String getHeaderName() {
        return NAME;
    }

}
