package nl.tweeenveertig.seagull.command.base.factory;

import nl.tweeenveertig.seagull.command.base.organisation.DeleteOrganisationsCommand;
import nl.tweeenveertig.seagull.command.base.organisation.GetOrganisationsCommand;
import nl.tweeenveertig.seagull.command.base.organisation.PostOrganisationsCommand;
import nl.tweeenveertig.seagull.command.base.organisation.PutOrganisationsCommand;
import nl.tweeenveertig.seagull.model.Organisation;

/**
 * OrganisationsCommandFactory is the interface for creating the get, post, update and delete commands
 * for organisations.
 * @author Ruben Zorgman
 */
public interface OrganisationsCommandFactory {

    /**
     * Creates a command that retrieves organisations.
     * @return The GetOrganisationsCommand
     */
    public GetOrganisationsCommand createGetOrganisationsCommand();

    /**
     * Creates a command that creates an organisation.
     * @param organisation The organisation that has to be created
     * @return The PostOrganisationsCommand
     */
    public PostOrganisationsCommand createPostOrganisationsCommand(Organisation organisation);

    /**
     * Creates a command that deletes an existing organisation.
     * @param id The id of the organisation that has to be deleted
     * @return The DeleteOrganisationsCommand
     */
    public DeleteOrganisationsCommand createDeleteOrganisationsCommand(int id);

    /**
     * Creates a command that updates an existing organisation.
     * @param organisation The organisation that has to be updated
     * @return The PutOrganisationsCommand
     */
    public PutOrganisationsCommand createPutOrganisationsCommand(Organisation organisation);

}
