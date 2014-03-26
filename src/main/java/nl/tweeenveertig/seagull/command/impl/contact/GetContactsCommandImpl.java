package nl.tweeenveertig.seagull.command.impl.contact;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nl.tweeenveertig.seagull.command.base.contact.GetContactsCommand;
import nl.tweeenveertig.seagull.command.impl.AbstractGetCommand;
import nl.tweeenveertig.seagull.header.AcceptHeader;
import nl.tweeenveertig.seagull.header.AuthorizationHeader;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Contact;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JavaType;

/**
 * GetContactsCommandImpl is the implementation class that retrieves all contacts.
 * @author Ruben Zorgman
 */
public class GetContactsCommandImpl extends AbstractGetCommand<HttpGet, Contact> implements GetContactsCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetContactsCommandImpl.class);

    /**
     * Creates an instance of GetContactsCommandImpl.
     * @param account The account
     */
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
            LOGGER.error("IO exception: could convert JSON data to java object: " + e.getLocalizedMessage());
        }
        return contacts;
    }

    @Override
    protected HttpGet createRequest(String url) {
        return new HttpGet(url);
    }

    /**
     * Gets the return object. If an error occurs, the method will return an empty list.
     * @param response The HttpResponse
     * @return List of Contacts
     */
    public List<Contact> getReturnObject(HttpResponse response) {
        try {
            return createObjectsList(createJsonString(response));
        } catch (IOException e) {
            LOGGER.error("IO exception: could not convert EntityUtils to String with JSON data, message: " + e.getLocalizedMessage());
            return Collections.<Contact> emptyList();
        }
    }
}
