package nl.tweeenveertig.seagull.command.impl.organisation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.tweeenveertig.seagull.command.base.organisation.PutOrganisationsCommand;
import nl.tweeenveertig.seagull.header.AuthorizationHeader;
import nl.tweeenveertig.seagull.header.ContentTypeHeader;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Organisation;

import org.apache.http.client.methods.HttpPut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PutOrganisationsCommandImpl is the implementation class to update an existing organisation.
 * @author Ruben Zorgman
 */
public class PutOrganisationsCommandImpl extends AbstractEnclosingOrganisationsCommand<HttpPut, Organisation> implements PutOrganisationsCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(PutOrganisationsCommandImpl.class);

    /**
     * Creates an instance of PutOrganisationsCommandImpl.
     * @param account The account
     * @param organisation The organisation that has to be updated
     */
    public PutOrganisationsCommandImpl(Account account, Organisation organisation) {
        super(account, organisation);
        setHeader(new ContentTypeHeader("application/json"));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
    }

    @Override
    protected HttpPut createRequest(String url) {
        return new HttpPut(url);
    }

    @Override
    public List<Organisation> call() {
        try {
            addDataToEnclosingRequest(convertObjectToJsonString());
            return super.call();
        } catch (IOException e) {
            LOGGER.error("IO exception: failed to add data to the PUT request, message: " + e.getLocalizedMessage());
        }
        return new ArrayList<Organisation>();
    }

}
