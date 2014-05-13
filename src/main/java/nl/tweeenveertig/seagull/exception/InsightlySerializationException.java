package nl.tweeenveertig.seagull.exception;

/**
 * Class for serialization exceptions.
 * @author Ruben Zorgman
 */
public class InsightlySerializationException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates an instance of InsightlySerializationException.
     * @param message Exception message
     */
    public InsightlySerializationException(String message) {
        super(message);

    }

}
