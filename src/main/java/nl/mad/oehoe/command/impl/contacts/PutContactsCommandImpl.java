package nl.mad.oehoe.command.impl.contacts;

import java.util.List;

import nl.mad.oehoe.command.base.contacts.PutContactsCommand;
import nl.mad.oehoe.header.AuthorizationHeader;
import nl.mad.oehoe.header.ContentTypeHeader;
import nl.mad.oehoe.model.Account;
import nl.mad.oehoe.model.Contact;

import org.apache.http.client.methods.HttpPut;

public class PutContactsCommandImpl extends AbstractPostContactsCommand<HttpPut, Contact> implements PutContactsCommand {

    public PutContactsCommandImpl(Account account, Contact contact) {
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
    public List<Contact> call() {
        addDataToPostRequest();
        return super.call();
    }

}
