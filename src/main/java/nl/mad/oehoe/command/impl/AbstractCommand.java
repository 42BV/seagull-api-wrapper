package nl.mad.oehoe.command.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

import nl.mad.oehoe.header.AbstractHeader;
import nl.mad.oehoe.model.Account;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/** 
 * AbstractCommand is the abstract class that is used by all commands. 
 * @param <M> The HttpRequestBase
 * @param <N> The generic object
 * @author Ruben Zorgman
 */
public abstract class AbstractCommand<M extends HttpRequestBase, N> implements Callable<List<N>> {
    private M request;
    private Account account;

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCommand.class);

    /**
     * String that is used to append to the URL.
     */
    protected static final String CONTACTS_URL_STRING = "Contacts";

    /**
     * Creates an instance of AbstractCommand.
     * @param account The account
     * @param url The URL of the Insightly API
     */
    public AbstractCommand(Account account, String url) {
        this.request = createRequest(url);
        this.account = account;
    }

    /** 
     * Call executes the HttpRequest.
     * @return List<N> A list of objects
     */
    public List<N> call() {
        CloseableHttpResponse response = null;
        try {
            response = account.getHttpClient().execute(request);
            LOGGER.info("Request:" + request.getRequestLine());
            LOGGER.info("Statusline: " + response.getStatusLine());
        } catch (IOException e) {
            LOGGER.error("IO exception, message: " + e.getLocalizedMessage());
        }
        return getReturnObject(response);
    }

    /**
     * GetReturnObject.
     * @param httpResponse The HttpResponse
     * @return A list of objects
     */
    public List<N> getReturnObject(HttpResponse httpResponse) {
        return null;
    }

    /**
     * Sets a header for the request.
     * @param header The header
     */
    public void setHeader(AbstractHeader header) {
        header.setHeader(request);
    }

    /**
     * Creates a new instance of an ObjectMapper.
     * @return A new instance of an ObjectMapper
     */
    public ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return configureObjectMapper(objectMapper);
    }

    protected M getRequestBase() {
        return request;
    }

    protected abstract M createRequest(String url);

    private ObjectMapper configureObjectMapper(ObjectMapper objectMapper) {
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        //objectMapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true);
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        return objectMapper;
    }
}
