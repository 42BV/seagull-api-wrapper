package nl.mad.http;

import org.apache.commons.codec.binary.Base64;

public class AccountCredentials {
    private String url;
    private String token;

    public AccountCredentials(String url, String token) {
        this.token = token;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBase64ApiKey() {
        byte[] encoded = Base64.encodeBase64(getToken().getBytes());
        return new String(encoded);
    }

}