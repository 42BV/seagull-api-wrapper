package nl.tweeenveertig.seagull.command.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import nl.tweeenveertig.seagull.model.Account;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AbstractEnclosingRequest is an abstract class that is used by classes who do a PUT or POST request.
 * @author ruben Zorgman
 *
 * @param <M> The HttpRequestBase
 * @param <N> The type parameter
 */
public abstract class AbstractEnclosingRequest<M extends HttpEntityEnclosingRequestBase, N> extends AbstractCommand<M, N> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractEnclosingRequest.class);

    public AbstractEnclosingRequest(Account account, String url) {
        super(account, url);
    }

    /**
     * Creates a StringEntity that can be set as an entity to the corresponding HttpRequest.
     * The StringEntity contains a JSON string with the converted java objects.
     * @throws IOException 
     */
    public void addDataToEnclosingRequest(String jsonData) throws IOException {
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(jsonData);
            getRequestBase().setEntity(stringEntity);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Unsupported encoding exception, message: " + e.getLocalizedMessage());
            throw new IOException(e);
        }
    }

}
