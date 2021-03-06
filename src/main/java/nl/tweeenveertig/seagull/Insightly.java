package nl.tweeenveertig.seagull;

import java.util.List;

import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.AccountCredentials;
import nl.tweeenveertig.seagull.model.Contact;
import nl.tweeenveertig.seagull.model.Organisation;

import org.apache.http.impl.client.CloseableHttpClient;

/**
 * Insightly class contains all the methods that a user needs in order to do CRUD operations
 * on the Insightly API. When making an instance of this class, an Insightly API key and Insightly API URL are needed.
 * The API key can be be found by logging into Insightly and going to the 'My Info' page, then the 'User Settings' tab.
 * The URL can be found in the Insightly API information pages.
 * @author Ruben Zorgman
 */
public class Insightly {

    private Account account;
    private static final String URL = "https://api.insight.ly/v2.1";

    /**
     * Creates an instance of Insightly, with only the API key as parameter.
     * It will use the v2.1 URL for the Insightly API. If this is outdated,
     * use the constructor where you can set the URL.
     * @param apiKey The Insightly API Key
     */
    public Insightly(String apiKey) {
        account = new Account(new AccountCredentials(apiKey, URL));
    }

    /**
     * Creates an instance of Insightly, which takes two arguments.
     * @param apiKey The Insightly API Key
     * @param url The URL for the Insightly API
     */
    public Insightly(String apiKey, String url) {
        account = new Account(new AccountCredentials(apiKey, url));
    }

    /**
     * Deletes a contact, by using the contact's id.
     * @param id The contact's id.
     */
    public void deleteContact(int id) {
        account.getContactsCommandFactory().createDeleteContactsCommand(id).call();
    }

    /**
     * Updates an existing contact.
     * @param contact The contact that is updated
     */
    public void updateContact(Contact contact) {
        account.getContactsCommandFactory().createPutContactsCommand(contact).call();
    }

    /**
     * Creates a contact.
     * @param contact The contact that is created
     */
    public void createContact(Contact contact) {
        account.getContactsCommandFactory().createPostContactsCommand(contact).call();
    }

    /**
     * Gets a list of contacts.
     * @return List of contacts
     */
    public List<Contact> getContacts() {
        return account.getContactsCommandFactory().createGetContactsCommand().call();
    }

    /**
     * Deletes an organisation, by using the organisation's id.
     * @param id The organisation's id.
     */
    public void deleteOrganisation(int id) {
        account.getOrganisationsCommandFactory().createDeleteOrganisationsCommand(id).call();
    }

    /**
     * Updates an existing contact.
     * @param organisation The organisation that is updated
     */
    public void updateOrganisation(Organisation organisation) {
        account.getOrganisationsCommandFactory().createPutOrganisationsCommand(organisation).call();
    }

    /**
     * Creates a contact.
     * @param organisation The organisation that is created
     */
    public void createOrganisation(Organisation organisation) {
        account.getOrganisationsCommandFactory().createPostOrganisationsCommand(organisation).call();
    }

    /**
     * Gets a list of contacts.
     * @return List of contacts
     */
    public List<Organisation> getOrganisations() {
        return account.getOrganisationsCommandFactory().createGetOrganisationsCommand().call();
    }

    /**
     * setHttpClient gives the ability to set an existing HttpClient which is defined by the users, instead of using
     * the default once that is provided by the API.
     * @param httpClient The CloseableHttpClient
     */
    public void setHttpClient(CloseableHttpClient httpClient) {
        account.setHttpClient(httpClient);
    }

}
