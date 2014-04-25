package nl.tweeenveertig.seagull.command.impl.organisation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nl.tweeenveertig.seagull.command.base.organisation.GetOrganisationsCommand;
import nl.tweeenveertig.seagull.command.impl.AbstractGetCommand;
import nl.tweeenveertig.seagull.header.AcceptHeader;
import nl.tweeenveertig.seagull.header.AuthorizationHeader;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Organisation;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JavaType;

/**
 * GetOrganisationsCommandImpl is the implementation class that retrieves all organisations.
 * @author Ruben Zorgman
 */
public class GetOrganisationsCommandImpl extends AbstractGetCommand<HttpGet, Organisation> implements GetOrganisationsCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetOrganisationsCommandImpl.class);

    /**
     * Creates an instance of GetOrganisationsCommandImpl.
     * @param account The account
     */
    public GetOrganisationsCommandImpl(Account account) {
        super(account, modifyUrl(account.getAccountCredentials().getUrl()));
        setHeader(new AcceptHeader("application/json"));
        setHeader(new AuthorizationHeader(account.getAccountCredentials().getBase64ApiKey()));
    }

    //Static, omdat super() deze methode anders niet accepteert
    private static String modifyUrl(String url) {
        url += ORGANISATIONS_URL_STRING;
        return url;
    }

    @Override
    public List<Organisation> createObjectsList(String jsonString) {
        JavaType type = createObjectMapper().getTypeFactory().constructCollectionType(List.class, Organisation.class);
        List<Organisation> organisations = new ArrayList<Organisation>();
        try {
            organisations = createObjectMapper().readValue(jsonString, type);
        } catch (IOException e) {
            LOGGER.error("IO exception: could not convert JSON data to java object: " + e.getLocalizedMessage());
        }
        return organisations;
    }

    @Override
    protected HttpGet createRequest(String url) {
        return new HttpGet(url);
    }

    /**
     * Gets the return object. If an error occurs, the method will return an empty list.
     * @param response The HttpResponse
     * @return List of Organisations
     */
    public List<Organisation> getReturnObject(HttpResponse response) {
        try {
            return createObjectsList(createJsonString(response));
        } catch (IOException e) {
            LOGGER.error("IO exception: could not convert EntityUtils to String with JSON data, message: " + e.getLocalizedMessage());
            return Collections.<Organisation> emptyList();
        }
    }

}
