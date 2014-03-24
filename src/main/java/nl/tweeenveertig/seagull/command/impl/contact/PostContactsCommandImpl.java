package nl.tweeenveertig.seagull.command.impl.contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.tweeenveertig.seagull.command.base.contact.PostContactsCommand;
import nl.tweeenveertig.seagull.header.AuthorizationHeader;
import nl.tweeenveertig.seagull.header.ContentTypeHeader;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Contact;

import org.apache.http.client.methods.HttpPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PostContactsCommandImpl is the implementation class that creates a contact.
 * @author Ruben Zorgman
 */
public class PostContactsCommandImpl extends AbstractPostContactsCommand<HttpPost, Contact> implements PostContactsCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostContactsCommandImpl.class);

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
        try {
            addDataToPostRequest();
            return super.call();
        } catch (IOException e) {
            LOGGER.error("IO exception: failed to add data to the POST request, message: " + e.getLocalizedMessage());
        }
        return new ArrayList<Contact>();
    }

}
