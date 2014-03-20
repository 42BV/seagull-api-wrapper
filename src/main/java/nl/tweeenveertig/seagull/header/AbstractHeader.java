package nl.tweeenveertig.seagull.header;

import org.apache.http.client.methods.HttpRequestBase;

/**
 * AbstractHeader is the abstract class for all headers, that can be added to a HttpRequest.
 * @author Ruben Zorgman
 */
public abstract class AbstractHeader {
    private String value;

    /**
     * Creates a new instance of AbstractHeader.
     * @param value The value for the Httpheader
     */
    public AbstractHeader(String value) {
        this.value = value;
    }

    /**
     * Sets the header for the HttpRequest.
     * @param request The HttpRequest
     */
    public void setHeader(HttpRequestBase request) {
        request.setHeader(getHeaderName(), getHeaderValue());
    }

    /**
     *Gets the header name.
     * @return String The String with the header name.
     */
    public abstract String getHeaderName();

    public String getHeaderValue() {
        return value;
    }
}
