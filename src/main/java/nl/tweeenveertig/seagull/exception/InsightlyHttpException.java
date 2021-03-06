package nl.tweeenveertig.seagull.exception;

/**
 * Class for Http exceptions.
 * @author Ruben Zorgman
 */
public class InsightlyHttpException extends AbstractInsightlyException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates an instance of InsightlyHttpException.
     * @param message Exception message
     */
    public InsightlyHttpException(String message) {
        super(message);
    }

}
