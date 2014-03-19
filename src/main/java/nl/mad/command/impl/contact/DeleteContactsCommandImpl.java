package nl.mad.command.impl.contact;

import nl.mad.command.base.contact.DeleteContactsCommand;
import nl.mad.command.impl.AbstractCommand;
import nl.mad.header.AuthorizationHeader;
import nl.mad.model.Account;
import nl.mad.model.Contact;

import org.apache.http.client.methods.HttpDelete;

public class DeleteContactsCommandImpl extends AbstractCommand<HttpDelete, Contact> implements DeleteContactsCommand {

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
