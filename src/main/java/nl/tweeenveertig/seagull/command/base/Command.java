package nl.tweeenveertig.seagull.command.base;

import java.util.List;

/**
 * The command base class. 
 * @author Ruben Zorgman
 * @param <N> The type parameter
 */
public interface Command<N> {
    /**
     * @return List of objects
     */
    List<N> call();
}
