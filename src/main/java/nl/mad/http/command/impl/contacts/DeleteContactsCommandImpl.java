package nl.mad.http.command.impl.contacts;

import nl.mad.http.Account;
import nl.mad.http.command.base.contacts.DeleteContactsCommand;
import nl.mad.http.command.impl.AbstractCommand;
import nl.mad.http.header.AuthorizationHeader;
import nl.mad.model.Contacts;

import org.apache.http.client.methods.HttpDelete;

public class DeleteContactsCommandImpl extends AbstractCommand<HttpDelete, Contacts> implements DeleteContactsCommand {

    public DeleteContactsCommandImpl(Account account, int id) {
        super(account, modifyUrl(account.getAccountCredentials().getUrl(), id));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
    }

    //Static, omdat super() deze methode anders niet accepteert
    private static String modifyUrl(String url, int id) {
        url += CONTACTS_URL_STRING + "/" + id;
        return url;
    }

    @Override
    protected HttpDelete createRequest(String url) {
        return new HttpDelete(url);
    }

}
