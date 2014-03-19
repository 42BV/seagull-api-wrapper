package nl.mad.oehoe.command.base.factory;

import nl.mad.oehoe.command.base.contact.DeleteContactsCommand;
import nl.mad.oehoe.command.base.contact.GetContactsCommand;
import nl.mad.oehoe.command.base.contact.PostContactsCommand;
import nl.mad.oehoe.command.base.contact.PutContactsCommand;
import nl.mad.oehoe.model.Contact;

public interface ContactsCommandFactory {

    GetContactsCommand createGetContactsCommand();

    PostContactsCommand createPostContactsCommand(Contact contacts);

    DeleteContactsCommand createDeleteContactsCommand(int id);

    PutContactsCommand createPutContactsCommand(Contact contact);

}
