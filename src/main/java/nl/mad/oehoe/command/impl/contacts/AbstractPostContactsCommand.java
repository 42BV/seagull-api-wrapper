package nl.mad.oehoe.command.impl.contacts;

import java.io.UnsupportedEncodingException;

import nl.mad.oehoe.command.impl.AbstractCommand;
import nl.mad.oehoe.model.Account;
import nl.mad.oehoe.model.Contact;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * AbstractPostContactsCommand is an abstract class that is used by PutContactsCommandImpl and PostContactsCommandImpl
 * because both these classes use the same methods to post data to the Insightly API.
 * @param <M>
 * @param <N>
 * @author Ruben Zorgman
 */
public abstract class AbstractPostContactsCommand<M extends HttpEntityEnclosingRequestBase, N> extends AbstractCommand<M, N> {

    private Contact contact;

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPostContactsCommand.class);

    /**
     * Creates.
     * @param account The account
     * @param contact The contact
     */
    public AbstractPostContactsCommand(Account account, Contact contact) {
        super(account, modifyUrl(account.getAccountCredentials().getUrl()));
        this.contact = contact;
    }

    //Static, omdat super() deze methode anders niet accepteert
    private static String modifyUrl(String url) {
        url += CONTACTS_URL_STRING;
        return url;
    }

    /**
     * Creates a StringEntity that can be set as an entity to the corresponding HttpRequest.
     * The StringEntity contains a JSON string with the converted java objects.
     */
    protected void addDataToPostRequest() {
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(convertObjectToJsonString());
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Unsupported encoding exception, message: " + e.getLocalizedMessage());
        }
        getRequestBase().setEntity(stringEntity);
    }

    /**
     * Converts a java object to a JSON string.
     * @return The String with the JSON
     */
    protected String convertObjectToJsonString() {
        ObjectWriter writer = createObjectMapper().writer();
        String jsonString = null;
        try {

            jsonString = writer.writeValueAsString(contact);
        } catch (JsonProcessingException e) {
            LOGGER.error("Json processing exception, message: " + e.getLocalizedMessage());
        }
        return jsonString;
    }

}
