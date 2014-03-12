package nl.mad.http.command.impl.contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.mad.http.Account;
import nl.mad.http.command.base.contacts.GetContactsCommand;
import nl.mad.http.command.impl.AbstractGetCommand;
import nl.mad.http.header.AcceptHeader;
import nl.mad.http.header.AuthorizationHeader;
import nl.mad.model.Contacts;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.easygson.JsonEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetContactsCommandImpl extends AbstractGetCommand<HttpGet, Contacts> implements GetContactsCommand {

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
    protected String createJsonString(HttpResponse response) {
        String jsonString = null;
        try {
            jsonString = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            LOGGER.error("IO exception, message: " + e.getLocalizedMessage());
        }
        return jsonString;
    }

    @Override
    protected List<Contacts> createObjectsList(JsonEntity json) {
        List<Contacts> contacts = new ArrayList<Contacts>();
        for (JsonEntity contact : json) {
            try {
                contacts.add(createObjectMapper().readValue(contact.toString(), Contacts.class));
            } catch (IOException e) {
                LOGGER.error("IO exception, message: " + e.getLocalizedMessage());
            }
        }
        return contacts;
    }

    @Override
    protected HttpGet createRequest(String url) {
        return new HttpGet(url);
    }

    public List<Contacts> getReturnObject(HttpResponse response) {
        JsonEntity json = new JsonEntity(createJsonString(response));
        return createObjectsList(json);
    }
}
