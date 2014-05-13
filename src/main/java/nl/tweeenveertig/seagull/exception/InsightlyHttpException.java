package nl.tweeenveertig.seagull.exception;

/**
 * Class for all Http exceptions.
 * @author Ruben Zorgman
 */
public class InsightlyHttpException extends RuntimeException {

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
