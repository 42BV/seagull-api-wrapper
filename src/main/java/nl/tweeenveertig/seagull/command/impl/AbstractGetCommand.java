package nl.tweeenveertig.seagull.command.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.tweeenveertig.seagull.model.Account;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.type.CollectionType;

/**
 * AbstractGetCommand is an abstract class that is used by all get commands, because they share some methods.
 * @author Ruben Zorgman
 * @param <M> The HttpRequestBase
 * @param <N> The type parameter
 */
public abstract class AbstractGetCommand<M extends HttpRequestBase, N> extends AbstractCommand<M, N> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractGetCommand.class);

    /**
     * Creates an instance of AbstractGetCommand.
     * @param account The account
     * @param url The url that is used to call the API
     */
    public AbstractGetCommand(Account account, String url) {
        super(account, url);
    }

    /**
     * Generic method to convert JSON to Postduif objects. It uses the InputStream from a HttpResponse as input for
     * Jackson.
     * @param response The response
     * @param type Generic type
     * @return List of Objects
     */
    public List<N> createObjectsList(CloseableHttpResponse response, Class<N> type) {
        List<N> objectList = new ArrayList<N>();
        try {
            CollectionType collectionType = createObjectMapper().getTypeFactory().constructCollectionType(List.class, type);
            objectList = createObjectMapper().readValue(response.getEntity().getContent(), collectionType);
            response.getEntity().getContent().close();
        } catch (IOException e) {
            LOGGER.error("IOException, message: " + e.getLocalizedMessage());
        }
        return objectList;
    }

}
