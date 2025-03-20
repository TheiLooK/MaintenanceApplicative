package com.tp_note;

import com.tp_note.entities.primitives.User;
import com.tp_note.exceptions.auth.LogInException;
import com.tp_note.exceptions.auth.log_in.IncorrectPasswordException;
import com.tp_note.exceptions.auth.log_in.UserNotFoundException;
import com.tp_note.services.AuthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceTest {

    private AuthService authService;

    @BeforeEach
    void setUp() {
        // Réinitialisation de l'instance Singleton avant chaque test
        authService = AuthService.getInstance();
        authService.logOut(); // Assure que l'utilisateur est déconnecté avant chaque test
    }

    @AfterEach
    void tearDown() {
        // Réinitialisation après chaque test pour éviter toute contamination entre les tests
        authService.logOut();
    }

    @Test
    void testRegister() {
        authService.register("testUser", "password123");
        assertDoesNotThrow(() -> authService.logIn("testUser", "password123"));
    }

    @Test
    void testLogInSuccess() {
        authService.register("testUser", "password123");
        
        assertDoesNotThrow(() -> authService.logIn("testUser", "password123"));
        
        User loggedUser = authService.getLoggedUser();
        assertNotNull(loggedUser);
        assertEquals("testUser", loggedUser.name());
    }

    @Test
    void testLogInUserNotFound() {
        Exception exception = assertThrows(UserNotFoundException.class, () -> {
            authService.logIn("unknownUser", "password123");
        });

        assertEquals(UserNotFoundException.class, exception.getClass());
    }

    @Test
    void testLogInIncorrectPassword() {
        authService.register("testUser", "correctPassword");
        
        Exception exception = assertThrows(IncorrectPasswordException.class, () -> {
            authService.logIn("testUser", "wrongPassword");
        });

        assertEquals(IncorrectPasswordException.class, exception.getClass());
    }

    @Test
    void testLogout() {
        authService.register("testUser", "password123");
        assertDoesNotThrow(() -> authService.logIn("testUser", "password123"));

        authService.logOut();
        assertNull(authService.getLoggedUser());
    }

    @Test
    void testGetLoggedUser() {
        authService.register("testUser", "password123");
        assertDoesNotThrow(() -> authService.logIn("testUser", "password123"));

        User loggedUser = authService.getLoggedUser();
        assertNotNull(loggedUser);
        assertEquals("testUser", loggedUser.name());
    }

    @Test
    void testLogInTwice() {
        authService.register("testUser", "password123");
        assertDoesNotThrow(() -> authService.logIn("testUser", "password123"));

        LogInException exception = assertThrows(LogInException.class, () -> {
            authService.logIn("testUser", "password1234");
        });

        assertEquals(IncorrectPasswordException.class, exception.getClass());
    }
}
