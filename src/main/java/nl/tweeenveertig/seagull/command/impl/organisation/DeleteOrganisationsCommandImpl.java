package nl.tweeenveertig.seagull.command.impl.organisation;

import nl.tweeenveertig.seagull.command.base.organisation.DeleteOrganisationsCommand;
import nl.tweeenveertig.seagull.command.impl.AbstractCommand;
import nl.tweeenveertig.seagull.header.AuthorizationHeader;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Organisation;

import org.apache.http.client.methods.HttpDelete;

/**
 * DeleteOrganisationsCommandImpl is the implementation class, that takes care of deleting an existing contact. 
 * @author Ruben Zorgman
 */
public class DeleteOrganisationsCommandImpl extends AbstractCommand<HttpDelete, Organisation> implements DeleteOrganisationsCommand {

    /**
     * Creates an instance of DeleteOrganisationsCommandImpl.
     * @param account The account
     * @param id The id for the deleted organisation
     */
    public DeleteOrganisationsCommandImpl(Account account, int id) {
        super(account, modifyUrl(account.getAccountCredentials().getUrl(), id));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
    }

    //Static, because super() needs it.
    private static String modifyUrl(String url, int id) {
        url += ORGANISATIONS_URL_STRING + "/" + id;
        return url;
    }

    @Override
    protected HttpDelete createRequest(String url) {
        return new HttpDelete(url);
    }

}
