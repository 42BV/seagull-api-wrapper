package nl.mad.http.command.base.factory;

import nl.mad.http.command.base.contacts.DeleteContactsCommand;
import nl.mad.http.command.base.contacts.GetContactsCommand;
import nl.mad.http.command.base.contacts.PostContactsCommand;
import nl.mad.http.command.base.contacts.PutContactsCommand;
import nl.mad.model.Contacts;

public interface ContactsCommandFactory {

    public GetContactsCommand createGetContactsCommand();

    public PostContactsCommand createPostContactsCommand(Contacts contact);

    public DeleteContactsCommand createDeleteContactsCommand(int id);

    public PutContactsCommand createPutContactsCommand(Contacts contact);

}
