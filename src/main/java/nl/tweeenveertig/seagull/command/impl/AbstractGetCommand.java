package nl.tweeenveertig.seagull.command.impl;

import java.io.IOException;
import java.util.List;

import nl.tweeenveertig.seagull.model.Account;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.util.EntityUtils;

/**
 * AbstractGetCommand is an abstract class that is used by all get commands, because they share some methods.
 * @author Ruben Zorgman
 * @param <M> The HttpRequestBase
 * @param <N> The type parameter
 */
public abstract class AbstractGetCommand<M extends HttpRequestBase, N> extends AbstractCommand<M, N> {

    /**
     * Creates an instance of AbstractGetCommand.
     * @param account The account
     * @param url The url that is used to call the API
     */
    public AbstractGetCommand(Account account, String url) {
        super(account, url);
    }

    /**
     * Creates a String with JSON data from an HttpResponse.
     * @param response The HttpResponse
     * @return The String with the JSON data
     * @throws IOException 
     */
    public String createJsonString(HttpResponse response) throws IOException {
        String jsonString = null;
        try {
            jsonString = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new IOException(e);
        }
        return jsonString;
    }

    /**
     * Creates a list of objects, that are being converted from JSON to a java object, using Jackson.
     * @param jsonString The String with the JSON data
     * @return List of objects
     */
    public abstract List<N> createObjectsList(String jsonString);

}
