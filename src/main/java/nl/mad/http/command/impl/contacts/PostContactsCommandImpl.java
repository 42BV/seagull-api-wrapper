package nl.mad.http.command.impl.contacts;

import java.util.List;

import nl.mad.http.Account;
import nl.mad.http.command.base.contacts.PostContactsCommand;
import nl.mad.http.command.impl.AbstractPostCommand;
import nl.mad.http.header.AuthorizationHeader;
import nl.mad.http.header.ContentTypeHeader;
import nl.mad.model.Contacts;

import org.apache.http.client.methods.HttpPost;

public class PostContactsCommandImpl extends AbstractPostCommand<HttpPost, Contacts> implements PostContactsCommand {

    public PostContactsCommandImpl(Account account, Contacts contact) {
        super(account, contact);
        setHeader(new ContentTypeHeader("application/json"));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
    }

    @Override
    protected HttpPost createRequest(String url) {
        return new HttpPost(url);
    }

    @Override
    public List<Contacts> call() {
        addDataToPostRequest();
        return super.call();
    }

}
