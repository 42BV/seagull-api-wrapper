package nl.mad.command.impl.contact;

import java.util.List;

import nl.mad.command.base.contact.PostContactsCommand;
import nl.mad.header.AuthorizationHeader;
import nl.mad.header.ContentTypeHeader;
import nl.mad.model.Account;
import nl.mad.model.Contact;

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
