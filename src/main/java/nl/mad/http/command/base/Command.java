package nl.mad.http.command.base;

import java.util.List;

public interface Command<N> {
    public List<N> call();
}
