package nl.mad.http.command.impl.contacts;

import java.io.UnsupportedEncodingException;
import java.util.List;

import nl.mad.http.Account;
import nl.mad.http.command.base.contacts.PostContactsCommand;
import nl.mad.http.command.impl.AbstractCommand;
import nl.mad.http.header.AuthorizationHeader;
import nl.mad.http.header.ContentTypeHeader;
import nl.mad.model.Contacts;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

public class PostContactsCommandImpl extends AbstractCommand<HttpPost, Contacts> implements PostContactsCommand {

    private Contacts contact;

    private static final Logger LOGGER = LoggerFactory.getLogger(PostContactsCommandImpl.class);

    public PostContactsCommandImpl(Account account, Contacts contact) {
        super(account, modifyUrl(account.getAccountCredentials().getUrl()));
        this.contact = contact;
        setHeader(new ContentTypeHeader("application/json"));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
    }

    //Static, omdat super() deze methode anders niet accepteert
    private static String modifyUrl(String url) {
        return url += contactsUrlString;
    }

    @Override
    protected HttpPost createRequest(String url) {
        return new HttpPost(url);
    }

    @Override
    public List<Contacts> call() {
        addDataToPostRequest();
        return super.call();
    }

    public void addDataToPostRequest() {
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(convertObjectToJsonString(contact));
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("UnsupportedEncodingException, message: " + e.getLocalizedMessage());
        }
        getRequestBase().setEntity(stringEntity);
    }

    private String convertObjectToJsonString(Contacts contact) {
        ObjectWriter writer = createObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonString = null;
        try {
            jsonString = writer.writeValueAsString(contact);
        } catch (JsonProcessingException e) {
            LOGGER.error("JsonProcessingException, message: " + e.getLocalizedMessage());
        }
        return jsonString;
    }
}
