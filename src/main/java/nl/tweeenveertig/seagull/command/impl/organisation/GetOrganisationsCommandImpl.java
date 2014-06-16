package nl.tweeenveertig.seagull.command.impl.organisation;

import java.util.List;

import nl.tweeenveertig.seagull.command.base.organisation.GetOrganisationsCommand;
import nl.tweeenveertig.seagull.command.impl.AbstractGetCommand;
import nl.tweeenveertig.seagull.header.AcceptHeader;
import nl.tweeenveertig.seagull.header.AuthorizationHeader;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Organisation;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

/**
 * GetOrganisationsCommandImpl is the implementation class that retrieves all organisations.
 * @author Ruben Zorgman
 */
public class GetOrganisationsCommandImpl extends AbstractGetCommand<HttpGet, Organisation> implements GetOrganisationsCommand {

    /**
     * Creates an instance of GetOrganisationsCommandImpl.
     * @param account The account
     */
    public GetOrganisationsCommandImpl(Account account) {
        super(account, modifyUrl(account.getAccountCredentials().getUrl()));
        setHeader(new AcceptHeader("application/json"));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
    }

    //Static, because super() needs it.
    private static String modifyUrl(String url) {
        url += ORGANISATIONS_URL_STRING;
        return url;
    }

    @Override
    protected HttpGet createRequest(String url) {
        return new HttpGet(url);
    }

    /**
     * Gets the return object. If an error occurs, the method will return an empty list.
     * @param response The HttpResponse
     * @return List of Organisations
     */
    public List<Organisation> getReturnObject(CloseableHttpResponse response) {
        return createObjectsList(response, Organisation.class);
    }

}
