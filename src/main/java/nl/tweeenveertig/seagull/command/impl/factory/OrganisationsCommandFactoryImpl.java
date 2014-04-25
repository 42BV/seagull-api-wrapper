package nl.tweeenveertig.seagull.command.impl.factory;

import nl.tweeenveertig.seagull.command.base.factory.OrganisationsCommandFactory;
import nl.tweeenveertig.seagull.command.base.organisation.DeleteOrganisationsCommand;
import nl.tweeenveertig.seagull.command.base.organisation.GetOrganisationsCommand;
import nl.tweeenveertig.seagull.command.base.organisation.PostOrganisationsCommand;
import nl.tweeenveertig.seagull.command.base.organisation.PutOrganisationsCommand;
import nl.tweeenveertig.seagull.command.impl.organisation.DeleteOrganisationsCommandImpl;
import nl.tweeenveertig.seagull.command.impl.organisation.GetOrganisationsCommandImpl;
import nl.tweeenveertig.seagull.command.impl.organisation.PostOrganisationsCommandImpl;
import nl.tweeenveertig.seagull.command.impl.organisation.PutOrganisationsCommandImpl;
import nl.tweeenveertig.seagull.model.Account;
import nl.tweeenveertig.seagull.model.Organisation;

/**
 * OrganisationsCommandFactoryImpl is the implementation class that creates the update, get, post and delete commands
 * for an organisation.
 * @author Ruben Zorgman
 */
public class OrganisationsCommandFactoryImpl implements OrganisationsCommandFactory {
    private Account account;

    /**
     * Creates an instance of OrganisationsCommandFactoryImpl.
     * @param account The account 
     */
    public OrganisationsCommandFactoryImpl(Account account) {
        this.account = account;
    }

    @Override
    public GetOrganisationsCommand createGetOrganisationsCommand() {
        return new GetOrganisationsCommandImpl(account);
    }

    @Override
    public PostOrganisationsCommand createPostOrganisationsCommand(Organisation organisation) {
        return new PostOrganisationsCommandImpl(account, organisation);
    }

    @Override
    public DeleteOrganisationsCommand createDeleteOrganisationsCommand(int id) {
        return new DeleteOrganisationsCommandImpl(account, id);
    }

    @Override
    public PutOrganisationsCommand createPutOrganisationsCommand(Organisation organisation) {
        return new PutOrganisationsCommandImpl(account, organisation);
    }
}
