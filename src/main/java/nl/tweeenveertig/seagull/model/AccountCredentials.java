package nl.tweeenveertig.seagull.model;

import nl.tweeenveertig.seagull.exception.InsightlyHttpException;

import org.apache.commons.codec.binary.Base64;

/**
 * AccountCredentials contains the login information that is used to connect.
 * A URL and API authentication key are necessary.
 * @author Ruben Zorgman
 *
 */
public class AccountCredentials {

    private final String url;
    private final String apiKey;

    /**
     * Creates an instance of AccountCredentials with a URL and API authentication key.
     * @param apiKey The API authentication key.
     * @param url The URL for the Insightly API.
     */
    public AccountCredentials(String apiKey, String url) {
        this.apiKey = apiKey;
        this.url = url;
    }

    /**
     * Gets the URL, an exception is thrown if the URL is empty.
     * @return String
     */
    public String getUrl() {
        if (url == null) {
            throw new InsightlyHttpException("The URL is empty");
        }
        return url;
    }

    /**
     * Gets the API key, an exception is thrown if the API key is empty.
     * @return String
     */
    public String getApiKey() {
        if (apiKey == null) {
            throw new InsightlyHttpException("The API key is empty");
        }
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
