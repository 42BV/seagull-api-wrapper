package nl.mad.http.command.impl.contacts;

import java.util.List;

import nl.mad.http.Account;
import nl.mad.http.command.base.contacts.PutContactsCommand;
import nl.mad.http.command.impl.AbstractPostCommand;
import nl.mad.http.header.AuthorizationHeader;
import nl.mad.http.header.ContentTypeHeader;
import nl.mad.model.Contacts;

import org.apache.http.client.methods.HttpPut;

public class PutContactsCommandImpl extends AbstractPostCommand<HttpPut, Contacts> implements PutContactsCommand {

    public PutContactsCommandImpl(Account account, Contacts contact) {
        super(account, contact);
        setHeader(new ContentTypeHeader("application/json"));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
        System.out.println(contact.getContactId());
    }

    @Override
    protected HttpPut createRequest(String url) {
        return new HttpPut(url);
    }

    @Override
    public List<Contacts> call() {
        addDataToPostRequest();
        return super.call();
    }

}
