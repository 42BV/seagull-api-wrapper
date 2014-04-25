package nl.tweeenveertig.seagull.command.impl.contact;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import nl.tweeenveertig.seagull.command.impl.AbstractCommand;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Contact;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * AbstractPostContactsCommand is an abstract class that is used by PutContactsCommandImpl and PostContactsCommandImpl
 * because both these classes use the same methods to post data to the Insightly API.
 * @param <M> The HttpEntityEnclosingRequestBase
 * @param <N> The generic object
 * @author Ruben Zorgman
 */
public abstract class AbstractPostContactsCommand<M extends HttpEntityEnclosingRequestBase, N> extends AbstractCommand<M, N> {

    private Contact contact;

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPostContactsCommand.class);

    /**
     * Creates an instance of AbstractPostContactsCommand.
     * @param account The account
     * @param contact The contact
     */
    public AbstractPostContactsCommand(Account account, Contact contact) {
        super(account, modifyUrl(account.getAccountCredentials().getUrl()));
        this.contact = contact;
    }

    //Static, because super() needs this method.
    private static String modifyUrl(String url) {
        url += CONTACTS_URL_STRING;
        return url;
    }

    /**
     * Creates a StringEntity that can be set as an entity to the corresponding HttpRequest.
     * The StringEntity contains a JSON string with the converted java objects.
     * @throws IOException 
     */
    public void addDataToEnclosingRequest() throws IOException {
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(convertObjectToJsonString());
            getRequestBase().setEntity(stringEntity);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Unsupported encoding exception, message: " + e.getLocalizedMessage());
            throw new UnsupportedEncodingException();
        } catch (JsonGenerationException e) {
            LOGGER.error("Json Generation Exception: could not convert from java object to JSON, message: " + e.getLocalizedMessage());
            throw new JsonGenerationException(e);
        }
    }

    /**
     * Converts a java object to a JSON string.
     * @return The String with the JSON
     * @throws JsonGenerationException 
     */
    public String convertObjectToJsonString() throws JsonGenerationException {
        ObjectWriter writer = createObjectMapper().writer();
        String jsonString = null;
        try {

            jsonString = writer.writeValueAsString(contact);
        } catch (JsonProcessingException e) {
            throw new JsonGenerationException(e);
        }
        return jsonString;
    }

}
