package nl.mad.http.command.impl.factory;

import nl.mad.http.Account;
import nl.mad.http.command.base.contacts.DeleteContactsCommand;
import nl.mad.http.command.base.contacts.GetContactsCommand;
import nl.mad.http.command.base.contacts.PostContactsCommand;
import nl.mad.http.command.base.contacts.PutContactsCommand;
import nl.mad.http.command.base.factory.ContactsCommandFactory;
import nl.mad.http.command.impl.contacts.DeleteContactsCommandImpl;
import nl.mad.http.command.impl.contacts.GetContactsCommandImpl;
import nl.mad.http.command.impl.contacts.PostContactsCommandImpl;
import nl.mad.http.command.impl.contacts.PutContactsCommandImpl;
import nl.mad.model.Contacts;

public class ContactsCommandFactoryImpl implements ContactsCommandFactory {
    private Account account;

    public ContactsCommandFactoryImpl(Account account) {
        this.account = account;
    }

    @Override
    public GetContactsCommand createGetContactsCommand() {
        return new GetContactsCommandImpl(account);
    }

    @Override
    public PostContactsCommand createPostContactsCommand(Contacts contact) {
        return new PostContactsCommandImpl(account, contact);
    }

    @Override
    public DeleteContactsCommand createDeleteContactsCommand(int id) {
        return new DeleteContactsCommandImpl(account, id);
    }

    public PutContactsCommand createPutContactsCommand(Contacts contact) {
        return new PutContactsCommandImpl(account, contact);
    }

}
