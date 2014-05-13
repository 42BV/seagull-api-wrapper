package nl.tweeenveertig.seagull.exception;

/**
 * Exception class that throws a deserialization exception.
 * @author Ruben Zorgman
 */
public class InsightlyDeserializationException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates an instance of InsightlyDeserializationException.
     * @param message String with the exception
     */
    public InsightlyDeserializationException(String message) {
        super(message);
    }

}
