package nl.tweeenveertig.seagull.exception;

/**
 * Abstract class for custom Insightly exceptions.
 * @author Ruben Zorgman
 */
public abstract class AbstractInsightlyException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates an instance of InsightlyException
     * @param message Exception message
     */
    public AbstractInsightlyException(String message) {
        super(message);
    }

}
