package nl.mad.http.command.impl;

import java.io.UnsupportedEncodingException;

import nl.mad.http.Account;
import nl.mad.model.Contacts;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

public abstract class AbstractPostCommand<M extends HttpEntityEnclosingRequestBase, N> extends AbstractCommand<M, N> {

    private Contacts contact;

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPostCommand.class);

    public AbstractPostCommand(Account account, Contacts contact) {
        super(account, modifyUrl(account.getAccountCredentials().getUrl()));
        this.contact = contact;
    }

    //Static, omdat super() deze methode anders niet accepteert
    private static String modifyUrl(String url) {
        url += CONTACTS_URL_STRING;
        return url;
    }

    protected void addDataToPostRequest() {
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(convertObjectToJsonString());
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Unsupported encoding exception, message: " + e.getLocalizedMessage());
        }
        getRequestBase().setEntity(stringEntity);
    }

    protected String convertObjectToJsonString() {
        ObjectWriter writer = createObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonString = null;
        try {

            jsonString = writer.writeValueAsString(contact);
        } catch (JsonProcessingException e) {
            LOGGER.error("Json processing exception, message: " + e.getLocalizedMessage());
        }
        return jsonString;
    }

}
