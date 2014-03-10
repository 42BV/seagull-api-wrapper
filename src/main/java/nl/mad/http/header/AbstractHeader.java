package nl.mad.http.header;

import org.apache.http.client.methods.HttpRequestBase;

public abstract class AbstractHeader {
    private String value;

    public AbstractHeader(String value) {
        this.value = value;
    }

    public void setHeader(HttpRequestBase request) {
        request.setHeader(getHeaderName(), getHeaderValue());
    }

    public abstract String getHeaderName();

    public String getHeaderValue() {
        return value;
    }
}
