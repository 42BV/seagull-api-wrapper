package nl.tweeenveertig.seagull.command.impl.factory;

import nl.tweeenveertig.seagull.command.base.contact.DeleteContactsCommand;
import nl.tweeenveertig.seagull.command.base.contact.GetContactsCommand;
import nl.tweeenveertig.seagull.command.base.contact.PostContactsCommand;
import nl.tweeenveertig.seagull.command.base.contact.PutContactsCommand;
import nl.tweeenveertig.seagull.command.base.factory.ContactsCommandFactory;
import nl.tweeenveertig.seagull.command.impl.contact.DeleteContactsCommandImpl;
import nl.tweeenveertig.seagull.command.impl.contact.GetContactsCommandImpl;
import nl.tweeenveertig.seagull.command.impl.contact.PostContactsCommandImpl;
import nl.tweeenveertig.seagull.command.impl.contact.PutContactsCommandImpl;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Contact;

/**
 * ContactsCommandFactoryImpl is the implementation class that creates the update, get, post and delete commands
 * for a contact.
 * @author Ruben Zorgman
 */
public class ContactsCommandFactoryImpl implements ContactsCommandFactory {
    private Account account;

    /**
     * Creates an instance of ContactsCommandFactoryImpl.
     * @param account The account 
     */
    public ContactsCommandFactoryImpl(Account account) {
        this.account = account;
    }

    @Override
    public GetContactsCommand createGetContactsCommand() {
        return new GetContactsCommandImpl(account);
    }

    @Override
    public PostContactsCommand createPostContactsCommand(Contact contact) {
        return new PostContactsCommandImpl(account, contact);
    }

    @Override
    public DeleteContactsCommand createDeleteContactsCommand(int id) {
        return new DeleteContactsCommandImpl(account, id);
    }

    @Override
    public PutContactsCommand createPutContactsCommand(Contact contact) {
        return new PutContactsCommandImpl(account, contact);
    }

}
