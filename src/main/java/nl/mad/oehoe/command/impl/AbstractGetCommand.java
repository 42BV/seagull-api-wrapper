package nl.mad.oehoe.command.impl;

import java.util.List;

import nl.mad.oehoe.model.Account;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

public abstract class AbstractGetCommand<M extends HttpRequestBase, N> extends AbstractCommand<M, N> {

    public AbstractGetCommand(Account account, String url) {
        super(account, url);
    }

    protected abstract String createJsonString(HttpResponse response);

    protected abstract List<N> createObjectsList(String jsonString);

}
