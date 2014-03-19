package nl.mad.command.impl.factory;

import nl.mad.command.base.contact.DeleteContactsCommand;
import nl.mad.command.base.contact.GetContactsCommand;
import nl.mad.command.base.contact.PostContactsCommand;
import nl.mad.command.base.contact.PutContactsCommand;
import nl.mad.command.base.factory.ContactsCommandFactory;
import nl.mad.command.impl.contact.DeleteContactsCommandImpl;
import nl.mad.command.impl.contact.GetContactsCommandImpl;
import nl.mad.command.impl.contact.PostContactsCommandImpl;
import nl.mad.command.impl.contact.PutContactsCommandImpl;
import nl.mad.model.Account;
import nl.mad.model.Contact;

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
