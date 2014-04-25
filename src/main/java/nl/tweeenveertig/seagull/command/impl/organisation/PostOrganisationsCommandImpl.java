package nl.tweeenveertig.seagull.command.impl.organisation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.tweeenveertig.seagull.command.base.organisation.PostOrganisationsCommand;
import nl.tweeenveertig.seagull.header.AuthorizationHeader;
import nl.tweeenveertig.seagull.header.ContentTypeHeader;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Organisation;

import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PostOrganisationsCommandImpl is the implementation class that creates an organisation.
 * @author Ruben Zorgman
 */
public class PostOrganisationsCommandImpl extends AbstractPostOrganisationsCommand<HttpPost, Organisation> implements PostOrganisationsCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostOrganisationsCommandImpl.class);

    /**
     * Creates an instance of PostOrganisationsCommandImpl.
     * @param account The account
     * @param organisation The organisation that has to be created
     */
    public PostOrganisationsCommandImpl(Account account, Organisation organisation) {
        super(account, organisation);
        setHeader(new ContentTypeHeader("application/json"));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
    }

    @Override
    protected HttpPost createRequest(String url) {
        return new HttpPost(url);
    }

    @Override
    public List<Organisation> call() {
        try {
            addDataToEnclosingRequest();
            return super.call();
        } catch (IOException e) {
            LOGGER.error("IO exception: failed to add data to the POST request, message: " + e.getLocalizedMessage());
        }
        return new ArrayList<Organisation>();
    }

}
