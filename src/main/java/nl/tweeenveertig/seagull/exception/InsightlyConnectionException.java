package nl.tweeenveertig.seagull.exception;

/**
 * Class for HTTP connection exceptions.
 * @author Ruben Zorgman
 */
public class InsightlyConnectionException extends AbstractInsightlyException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates an instance of InsightlyConnectionException.
     * @param message Exception message.
     */
    public InsightlyConnectionException(String message) {
        super(message);
    }

}
