package nl.tweeenveertig.seagull.command.base.factory;

import nl.tweeenveertig.seagull.command.base.contact.DeleteContactsCommand;
import nl.tweeenveertig.seagull.command.base.contact.GetContactsCommand;
import nl.tweeenveertig.seagull.command.base.contact.PostContactsCommand;
import nl.tweeenveertig.seagull.command.base.contact.PutContactsCommand;
import nl.tweeenveertig.seagull.model.Contact;

/**
 * ContactsCommandFactory is the interface for creating the get, post, update and delete commands
 * for contacts.
 * @author Ruben Zorgman
 */
public interface ContactsCommandFactory {

    /**
     * Creates a command that retrieves contacts.
     * @return The GetContactsCommand
     */
    public GetContactsCommand createGetContactsCommand();

    /**
     * Creates a command that creates a contact.
     * @param contact The contact that has to be created
     * @return The PostContactsCommand
     */
    public PostContactsCommand createPostContactsCommand(Contact contact);

    /**
     * Creates a command that deletes an existing contact.
     * @param id The id of the contact that has to be deleted
     * @return The DeleteContactsCommand
     */
    public DeleteContactsCommand createDeleteContactsCommand(int id);

    /**
     * Creates a command that updates an existing contact.
     * @param contact The contact that has to be updated
     * @return The PutContactsCommand
     */
    public PutContactsCommand createPutContactsCommand(Contact contact);

}
