package nl.mad.oehoe.model;


import org.apache.commons.codec.binary.Base64;

/**
 * AccountCredentials contains the login information that is used to connect.
 * A URL and API authentication key are necessary.
 * @author Ruben Zorgman
 *
 */
public class AccountCredentials {

    private static final String URL = "https://api.insight.ly/v2.1/";
    private final String apiKey;

    /**
     * Creates an instance of AccountCredentials with a URL and API authentication key.
     * @param apiKey The API authentication key.
     */
    public AccountCredentials(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUrl() {
        return URL;
    }

    public String getApiKey() {
        return apiKey;
    }

    /**
     * Returns a base64 encoded API authentication key.
     * @return base64 encoded String
     */
    public String getBase64ApiKey() {
        byte[] encoded = Base64.encodeBase64(getApiKey().getBytes());
        return new String(encoded);
    }

}
