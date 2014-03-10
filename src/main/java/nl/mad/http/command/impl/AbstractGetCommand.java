package nl.mad.http.command.impl;

import java.util.List;

import nl.mad.http.Account;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;
import org.easygson.JsonEntity;

public abstract class AbstractGetCommand<M extends HttpRequestBase, N> extends AbstractCommand<M, N> {

    public AbstractGetCommand(Account account, String url) {
        super(account, url);
    }

    protected abstract String createJsonString(HttpResponse response);

    protected abstract List<N> createObjectsList(JsonEntity json);

}
