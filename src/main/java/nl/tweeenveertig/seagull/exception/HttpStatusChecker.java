package nl.tweeenveertig.seagull.exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;

/**
 * HttpStatusChecker is responsible for checking the HTTP status and if needed to throw an exception.
 * @author Ruben Zorgman
 */
public class HttpStatusChecker {

    private static final Integer REDIRECTION_CODE = 300;
    private static final Integer CLIENT_CODE = 400;
    private static final Integer SERVER_CODE = 500;
    private static final Integer UNAUTHORIZED_CODE = 401;
    private static final Integer FORBIDDEN_CODE = 403;
    private static final Integer NOT_FOUND_CODE = 404;
    private static final Map<Integer, RuntimeException> EXCEPTION_MAP = createExceptionMap();

    /**
     * Craetes an instance of HttpStatusChecker
     */
    public HttpStatusChecker() {

    }

    /**
     * Checks the HTTP status
     * @param response CloseableHttpResponse
     */
    public void checkStatus(CloseableHttpResponse response) {
        int statusCode = response.getStatusLine().getStatusCode();
        if (EXCEPTION_MAP.containsKey(statusCode)) {
            throw EXCEPTION_MAP.get(statusCode);
        } else if (statusCode >= REDIRECTION_CODE && statusCode < CLIENT_CODE) {
            throw new InsightlyHttpException("Insightly redirection error, code: " + statusCode);
        } else if (statusCode >= CLIENT_CODE && statusCode < SERVER_CODE) {
            throw new InsightlyHttpException("Insightly client error, code: " + statusCode);
        } else if (statusCode >= SERVER_CODE) {
            throw new InsightlyHttpException("Insightly server error, error code: " + statusCode);
        }

    }

    private static Map<Integer, RuntimeException> createExceptionMap() {
        Map<Integer, RuntimeException> exceptionMap = new HashMap<Integer, RuntimeException>();
        exceptionMap.put(CLIENT_CODE, new InsightlyHttpException("Insightly bad request, error code: " + CLIENT_CODE));
        exceptionMap.put(UNAUTHORIZED_CODE, new InsightlyHttpException("Insightly unauthorized, error code: " + UNAUTHORIZED_CODE));
        exceptionMap.put(FORBIDDEN_CODE, new InsightlyHttpException("Insightly access forbidden, error code: " + FORBIDDEN_CODE));
        exceptionMap.put(NOT_FOUND_CODE, new InsightlyHttpException("Insightly URI not found, error code: " + NOT_FOUND_CODE));
        return Collections.unmodifiableMap(exceptionMap);
    }

}
