package nl.tweeenveertig.seagull.command.impl.contact;

import nl.tweeenveertig.seagull.command.base.contact.DeleteContactsCommand;
import nl.tweeenveertig.seagull.command.impl.AbstractCommand;
import nl.tweeenveertig.seagull.header.AuthorizationHeader;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Contact;

import org.apache.http.client.methods.HttpDelete;

/**
 * DeleteContactsCommandImpl is the implementation class, that takes care of deleting an existing contact. 
 * @author Ruben Zorgman
 */
public class DeleteContactsCommandImpl extends AbstractCommand<HttpDelete, Contact> implements DeleteContactsCommand {

    /**
     * Creates an instance of DeleteContactsCommandImpl.
     * @param account The account
     * @param id The id for the deleted contact
     */
    public DeleteContactsCommandImpl(Account account, int id) {
        super(account, modifyUrl(account.getAccountCredentials().getUrl(), id));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
    }

    //Static, because super() needs it.
    private static String modifyUrl(String url, int id) {
        url += CONTACTS_URL_STRING + "/" + id;
        return url;
    }

    @Override
    protected HttpDelete createRequest(String url) {
        return new HttpDelete(url);
    }

}
