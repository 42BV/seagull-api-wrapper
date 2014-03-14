package nl.mad.oehoe.command.impl.contacts;

import java.util.List;

import nl.mad.oehoe.command.base.contacts.PostContactsCommand;
import nl.mad.oehoe.header.AuthorizationHeader;
import nl.mad.oehoe.header.ContentTypeHeader;
import nl.mad.oehoe.model.Account;
import nl.mad.oehoe.model.Contact;

import org.apache.http.client.methods.HttpPost;

public class PostContactsCommandImpl extends AbstractPostContactsCommand<HttpPost, Contact> implements PostContactsCommand {

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
