package com.tp_note.entities;

import com.tp_note.entities.primitives.Password;
import com.tp_note.entities.primitives.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Auth {
    public User username;
    public Password password;
}
