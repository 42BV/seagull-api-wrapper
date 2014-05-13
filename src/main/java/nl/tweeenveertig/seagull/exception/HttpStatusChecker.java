package nl.tweeenveertig.seagull.exception;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.methods.CloseableHttpResponse;

public class HttpStatusChecker {

    private static final Map<Integer, RuntimeException> EXCEPTION_MAP = createExceptionMap();

    public HttpStatusChecker() {

    }

    public void checkStatus(CloseableHttpResponse response) {
        int statusCode = response.getStatusLine().getStatusCode();
        if (EXCEPTION_MAP.containsKey(statusCode)) {
            throw EXCEPTION_MAP.get(statusCode);
        } else if (statusCode >= 300 && statusCode < 400) {
            throw new InsightlyRedirectionException("Insightly redirection error, code: " + statusCode);
        } else if (statusCode >= 400 && statusCode < 500) {
            throw new InsightlyClientException("Insightly client error, code: " + statusCode);
        } else if (statusCode >= 500) {
            throw new InsightlyServerException("Insightly server error, error code: " + statusCode);
        }

    }

    private static Map<Integer, RuntimeException> createExceptionMap() {
        Map<Integer, RuntimeException> exceptionMap = new HashMap<Integer, RuntimeException>();
        exceptionMap.put(400, new InsightlyBadRequestException("Insightly bad request, error code: " + 400));
        exceptionMap.put(401, new InsightlyUnauthorizedException("Insightly unauthorized, error code: " + 401));
        exceptionMap.put(403, new InsightlyUnauthorizedException("Insightly access forbidden, error code: " + 403));
        exceptionMap.put(404, new InsightlyUriNotFoundException("Insightly URI not found, error code: " + 404));
        return Collections.unmodifiableMap(exceptionMap);
    }

}
