package nl.mad.oehoe.command.base;

import java.util.List;

public interface Command<N> {
    List<N> call();
}
