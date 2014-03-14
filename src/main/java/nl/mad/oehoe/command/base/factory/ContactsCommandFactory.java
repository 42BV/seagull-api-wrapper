package nl.mad.oehoe.command.base.factory;

import nl.mad.oehoe.command.base.contacts.DeleteContactsCommand;
import nl.mad.oehoe.command.base.contacts.GetContactsCommand;
import nl.mad.oehoe.command.base.contacts.PostContactsCommand;
import nl.mad.oehoe.command.base.contacts.PutContactsCommand;
import nl.mad.oehoe.model.Contact;

public interface ContactsCommandFactory {

    GetContactsCommand createGetContactsCommand();

    PostContactsCommand createPostContactsCommand(Contact contacts);

    DeleteContactsCommand createDeleteContactsCommand(int id);

    PutContactsCommand createPutContactsCommand(Contact contact);

}
