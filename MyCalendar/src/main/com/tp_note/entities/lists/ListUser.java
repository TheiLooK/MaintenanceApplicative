package com.tp_note.entities.lists;

import com.tp_note.entities.primitives.User;

import java.util.ArrayList;
import java.util.List;

public class ListUser {
    private final List<User> users;

    public ListUser(String list) {
        this.users = new ArrayList<>();
        for (String user : list.split(",")) {
            users.add(new User(user));
        }
    }

    public boolean contains(User user) {
        return users.contains(user);
    }
}
