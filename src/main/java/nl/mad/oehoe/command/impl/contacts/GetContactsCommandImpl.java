package nl.mad.oehoe.command.impl.contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.mad.oehoe.command.base.contact.GetContactsCommand;
import nl.mad.oehoe.command.impl.AbstractGetCommand;
import nl.mad.oehoe.header.AcceptHeader;
import nl.mad.oehoe.header.AuthorizationHeader;
import nl.mad.oehoe.model.Account;
import nl.mad.oehoe.model.Contact;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JavaType;

public class GetContactsCommandImpl extends AbstractGetCommand<HttpGet, Contact> implements GetContactsCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetContactsCommandImpl.class);

    public GetContactsCommandImpl(Account account) {
        super(account, modifyUrl(account.getAccountCredentials().getUrl()));
        setHeader(new AcceptHeader("application/json"));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
    }

    //Static, omdat super() deze methode anders niet accepteert
    private static String modifyUrl(String url) {
        url += CONTACTS_URL_STRING;
        return url;
    }

    @Override
    public List<Contact> createObjectsList(String jsonString) {
        JavaType type = createObjectMapper().getTypeFactory().constructCollectionType(List.class, Contact.class);
        List<Contact> contacts = new ArrayList<Contact>();
        try {
            contacts = createObjectMapper().readValue(jsonString, type);
        } catch (IOException e) {
            LOGGER.error("IO exception, message: " + e.getLocalizedMessage());
        }
        return contacts;
    }

    @Override
    protected HttpGet createRequest(String url) {
        return new HttpGet(url);
    }

    public List<Contact> getReturnObject(HttpResponse response) {
        return createObjectsList(createJsonString(response));
    }
}
