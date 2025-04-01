package com.tp_note.entities.lists;

import com.tp_note.entities.primitives.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserList {
    private final List<User> users;

    public UserList(String list) {
        this.users = new ArrayList<>();
        for (String user : list.split(",")) {
            users.add(new User(user));
        }
    }

    public boolean contains(User user) {
        return users.contains(user);
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        for (User user : users) {
            list.append(user.name()).append(", ");
        }
        return list.substring(0, list.length() - 2);
    }
}
