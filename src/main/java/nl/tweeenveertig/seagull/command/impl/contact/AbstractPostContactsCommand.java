package nl.tweeenveertig.seagull.command.impl.contact;

import nl.tweeenveertig.seagull.command.impl.AbstractEnclosingRequest;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Contact;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
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
public abstract class AbstractPostContactsCommand<M extends HttpEntityEnclosingRequestBase, N> extends AbstractEnclosingRequest<M, N> {

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
