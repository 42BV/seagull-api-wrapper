package nl.mad.command.base.factory;

import nl.mad.command.base.contact.DeleteContactsCommand;
import nl.mad.command.base.contact.GetContactsCommand;
import nl.mad.command.base.contact.PostContactsCommand;
import nl.mad.command.base.contact.PutContactsCommand;
import nl.mad.model.Contact;

public interface ContactsCommandFactory {

    GetContactsCommand createGetContactsCommand();

    PostContactsCommand createPostContactsCommand(Contact contacts);

    DeleteContactsCommand createDeleteContactsCommand(int id);

    PutContactsCommand createPutContactsCommand(Contact contact);

}
