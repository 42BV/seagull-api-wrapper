package nl.tweeenveertig.seagull.command.impl.contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.tweeenveertig.seagull.command.base.contact.PutContactsCommand;
import nl.tweeenveertig.seagull.header.AuthorizationHeader;
import nl.tweeenveertig.seagull.header.ContentTypeHeader;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Contact;

import org.apache.http.client.methods.HttpPut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PutContactsCommandImpl is the implementation class to update an existing contact.
 * @author Ruben Zorgman
 */
public class PutContactsCommandImpl extends AbstractPostContactsCommand<HttpPut, Contact> implements PutContactsCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(PutContactsCommandImpl.class);

    /**
     * Creates an instance of PutContactsCommandImpl.
     * @param account The account
     * @param contact The contact that has to be updated
     */
    public PutContactsCommandImpl(Account account, Contact contact) {
        super(account, contact);
        setHeader(new ContentTypeHeader("application/json"));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
    }

    @Override
    protected HttpPut createRequest(String url) {
        return new HttpPut(url);
    }

    @Override
    public List<Contact> call() {
        try {
            addDataToEnclosingRequest();
            return super.call();
        } catch (IOException e) {
            LOGGER.error("IO exception: failed to add data to the PUT request, message: " + e.getLocalizedMessage());
        }
        return new ArrayList<Contact>();
    }

}
