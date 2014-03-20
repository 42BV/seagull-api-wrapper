package nl.tweeenveertig.seagull.header;

/**
 * ContentTypeHeader is the header implementation for a ContentType HTTP header.
 * The MIME type of the body of the request (used with POST and PUT requests), to identify the type of 
 * data that a file contains.
 * @author Ruben Zorgman
 */
public class ContentTypeHeader extends AbstractHeader {

    private static final String NAME = "Content-Type";

    /**
     * Creates an instance of Acceptheader.
     * @param value The value for the ContentTypeHeader
     */
    public ContentTypeHeader(String value) {
        super(value);
    }

    @Override
    public String getHeaderName() {
        return NAME;
    }

}
