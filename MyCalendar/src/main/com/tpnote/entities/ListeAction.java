package com.tpnote.entities;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListeAction extends Action {
    List<Action> actions;

    public ListeAction(String name, List<Action> actions) {
        super(name);
        this.actions = actions;
    }

    @Override
    public String DO() {
        return IntStream.range(0, actions.size())
                .mapToObj(i -> String.format("%d. %s", i + 1, actions.get(i).name))
                .collect(Collectors.joining("\n"));
    }
}
