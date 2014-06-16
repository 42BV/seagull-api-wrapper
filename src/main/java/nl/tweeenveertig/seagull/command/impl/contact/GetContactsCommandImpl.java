package nl.tweeenveertig.seagull.command.impl.contact;

import java.util.List;

import nl.tweeenveertig.seagull.command.base.contact.GetContactsCommand;
import nl.tweeenveertig.seagull.command.impl.AbstractGetCommand;
import nl.tweeenveertig.seagull.header.AcceptHeader;
import nl.tweeenveertig.seagull.header.AuthorizationHeader;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Contact;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

/**
 * GetContactsCommandImpl is the implementation class that retrieves all contacts.
 * @author Ruben Zorgman
 */
public class GetContactsCommandImpl extends AbstractGetCommand<HttpGet, Contact> implements GetContactsCommand {

    /**
     * Creates an instance of GetContactsCommandImpl.
     * @param account The account
     */
    public GetContactsCommandImpl(Account account) {
        super(account, modifyUrl(account.getAccountCredentials().getUrl()));
        setHeader(new AcceptHeader("application/json"));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
    }

    //Static, because super() needs it.
    private static String modifyUrl(String url) {
        url += CONTACTS_URL_STRING;
        return url;
    }

    @Override
    protected HttpGet createRequest(String url) {
        return new HttpGet(url);
    }

    /**
     * Gets the return object. If an error occurs, the method will return an empty list.
     * @param response The HttpResponse
     * @return List of Contacts
     */
    public List<Contact> getReturnObject(CloseableHttpResponse response) {
        return createObjectsList(response, Contact.class);
    }
}
