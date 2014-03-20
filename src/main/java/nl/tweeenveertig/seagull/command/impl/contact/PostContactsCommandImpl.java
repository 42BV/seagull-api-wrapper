package nl.tweeenveertig.seagull.command.impl.contact;

import java.util.List;

import nl.tweeenveertig.seagull.command.base.contact.PostContactsCommand;
import nl.tweeenveertig.seagull.header.AuthorizationHeader;
import nl.tweeenveertig.seagull.header.ContentTypeHeader;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Contact;

import org.apache.http.client.methods.HttpPost;

/**
 * PostContactsCommandImpl is the implementation class that creates a contact.
 * @author Ruben Zorgman
 */
public class PostContactsCommandImpl extends AbstractPostContactsCommand<HttpPost, Contact> implements PostContactsCommand {

    /**
     * Creates an instance of PostContactsCommandImpl.
     * @param account The account
     * @param contact The contact that has to be created
     */
    public PostContactsCommandImpl(Account account, Contact contact) {
        super(account, contact);
        setHeader(new ContentTypeHeader("application/json"));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
    }

    @Override
    protected HttpPost createRequest(String url) {
        return new HttpPost(url);
    }

    @Override
    public List<Contact> call() {
        addDataToPostRequest();
        return super.call();
    }

}
