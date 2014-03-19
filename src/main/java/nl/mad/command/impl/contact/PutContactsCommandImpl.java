package nl.mad.command.impl.contact;

import java.util.List;

import nl.mad.command.base.contact.PutContactsCommand;
import nl.mad.header.AuthorizationHeader;
import nl.mad.header.ContentTypeHeader;
import nl.mad.model.Account;
import nl.mad.model.Contact;

import org.apache.http.client.methods.HttpPut;

public class PutContactsCommandImpl extends AbstractPostContactsCommand<HttpPut, Contact> implements PutContactsCommand {

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
        addDataToPostRequest();
        return super.call();
    }

}
