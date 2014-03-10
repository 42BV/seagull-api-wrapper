package nl.mad.http.command.base.factory;

import nl.mad.http.command.base.contacts.DeleteContactsCommand;
import nl.mad.http.command.base.contacts.GetContactsCommand;
import nl.mad.http.command.base.contacts.PostContactsCommand;
import nl.mad.http.command.base.contacts.PutContactsCommand;
import nl.mad.model.Contacts;

public interface ContactsCommandFactory {

    GetContactsCommand createGetContactsCommand();

    PostContactsCommand createPostContactsCommand(Contacts contact);

    DeleteContactsCommand createDeleteContactsCommand(int id);

    PutContactsCommand createPutContactsCommand(Contacts contact);

}
