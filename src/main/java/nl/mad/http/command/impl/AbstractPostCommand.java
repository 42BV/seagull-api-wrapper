package nl.mad.http.command.impl;

import nl.mad.http.Account;

import org.apache.http.client.methods.HttpRequestBase;

public abstract class AbstractPostCommand<M extends HttpRequestBase, N> extends AbstractCommand<M, N> {

    public AbstractPostCommand(Account account, String url) {
        super(account, url);
    }

    protected abstract void addDataToPostRequest();

    protected abstract String convertObjectToJsonString();

}
