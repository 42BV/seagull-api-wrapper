package nl.tweeenveertig.seagull.command.impl.organisation;

import nl.tweeenveertig.seagull.command.impl.AbstractEnclosingRequest;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Organisation;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * AbstractPostOrganisationsCommand is an abstract class that is used by PutOrganisationsCommandImpl and PostOrganisationsCommandImpl
 * because both these classes use the same methods to post data to the Insightly API.
 * @param <M> The HttpEntityEnclosingRequestBase
 * @param <N> The generic object
 * @author Ruben Zorgman
 */
public abstract class AbstractPostOrganisationsCommand<M extends HttpEntityEnclosingRequestBase, N> extends AbstractEnclosingRequest<M, N> {

    private Organisation organisation;

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractPostOrganisationsCommand.class);

    /**
     * Creates an instance of AbstractPostOrganisationsCommand.
     * @param account The account
     * @param organisation The organisation
     */
    public AbstractPostOrganisationsCommand(Account account, Organisation organisation) {
        super(account, modifyUrl(account.getAccountCredentials().getUrl()));
        this.organisation = organisation;
    }

    //Static, because super() needs this method.
    private static String modifyUrl(String url) {
        url += ORGANISATIONS_URL_STRING;
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

            jsonString = writer.writeValueAsString(organisation);
        } catch (JsonProcessingException e) {
            throw new JsonGenerationException(e);
        }
        return jsonString;
    }

}
