package nl.mad.oehoe.command.impl.factory;

import nl.mad.oehoe.command.base.contacts.DeleteContactsCommand;
import nl.mad.oehoe.command.base.contacts.GetContactsCommand;
import nl.mad.oehoe.command.base.contacts.PostContactsCommand;
import nl.mad.oehoe.command.base.contacts.PutContactsCommand;
import nl.mad.oehoe.command.base.factory.ContactsCommandFactory;
import nl.mad.oehoe.command.impl.contacts.DeleteContactsCommandImpl;
import nl.mad.oehoe.command.impl.contacts.GetContactsCommandImpl;
import nl.mad.oehoe.command.impl.contacts.PostContactsCommandImpl;
import nl.mad.oehoe.command.impl.contacts.PutContactsCommandImpl;
import nl.mad.oehoe.model.Account;
import nl.mad.oehoe.model.Contact;

/**
 * 
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
