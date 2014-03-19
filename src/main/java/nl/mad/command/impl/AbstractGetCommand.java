package nl.mad.command.impl;

import java.io.IOException;
import java.util.List;

import nl.mad.command.impl.contact.GetContactsCommandImpl;
import nl.mad.model.Account;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractGetCommand<M extends HttpRequestBase, N> extends AbstractCommand<M, N> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetContactsCommandImpl.class);

    public AbstractGetCommand(Account account, String url) {
        super(account, url);
    }

    public String createJsonString(HttpResponse response) {
        String jsonString = null;
        try {
            jsonString = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            LOGGER.error("IO exception, message: " + e.getLocalizedMessage());
        }
        return jsonString;
    }

    public abstract List<N> createObjectsList(String jsonString);

}
