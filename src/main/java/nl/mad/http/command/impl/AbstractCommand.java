package nl.mad.http.command.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

import nl.mad.http.Account;
import nl.mad.http.header.AbstractHeader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractCommand<M extends HttpRequestBase, N> implements Callable<List<N>> {
    protected M request;
    private HttpResponse response;
    private Account account;

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCommand.class);

    protected static final String contactsUrlString = "CONTACTS";

    public AbstractCommand(Account account, String url) {
        this.request = createRequest(url);
        this.account = account;
    }

    public List<N> call() {
        try {
            response = account.getHttpClient().execute(request);
            LOGGER.info("Request:" + request.getRequestLine());
            LOGGER.info("Statusline: " + response.getStatusLine());
        } catch (IOException e) {
            LOGGER.error("IOException, message: " + e.getLocalizedMessage());
        }
        return getReturnObject(response);
    }

    public List<N> getReturnObject(HttpResponse response) {
        return null;
    }

    public void setHeader(AbstractHeader header) {
        header.setHeader(request);
    }

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
        objectMapper.setSerializationInclusion(Include.NON_NULL);
        return objectMapper;
    }

}
