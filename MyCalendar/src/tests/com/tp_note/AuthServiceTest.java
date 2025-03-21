package com.tp_note;

import com.tp_note.entities.primitives.User;
import com.tp_note.exceptions.auth.LogInException;
import com.tp_note.exceptions.auth.log_in.IncorrectPasswordException;
import com.tp_note.exceptions.auth.log_in.UserNotFoundException;
import com.tp_note.exceptions.auth.register.UserAlreadyExistsException;
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
    void testRegister() throws UserAlreadyExistsException {
        authService.register("testUser1", "password123");
        assertDoesNotThrow(() -> authService.logIn("testUser1", "password123"));
    }

    @Test
    void testLogInSuccess() throws UserAlreadyExistsException {
        authService.register("testUser2", "password123");
        
        assertDoesNotThrow(() -> authService.logIn("testUser2", "password123"));
        
        User loggedUser = authService.getLoggedUser();
        assertNotNull(loggedUser);
        assertEquals("testUser2", loggedUser.name());
    }

    @Test
    void testLogInUserNotFound() {
        Exception exception = assertThrows(UserNotFoundException.class, () -> authService.logIn("unknownUser", "password123"));

        assertEquals(UserNotFoundException.class, exception.getClass());
    }

    @Test
    void testLogInIncorrectPassword() throws UserAlreadyExistsException {
        authService.register("testUser3", "correctPassword");
        
        Exception exception = assertThrows(IncorrectPasswordException.class, () -> authService.logIn("testUser3", "wrongPassword"));

        assertEquals(IncorrectPasswordException.class, exception.getClass());
    }

    @Test
    void testLogout() throws UserAlreadyExistsException {
        authService.register("testUser4", "password123");
        assertDoesNotThrow(() -> authService.logIn("testUser4", "password123"));

        authService.logOut();
        assertNull(authService.getLoggedUser());
    }

    @Test
    void testGetLoggedUser() throws UserAlreadyExistsException {
        authService.register("testUser5", "password123");
        assertDoesNotThrow(() -> authService.logIn("testUser5", "password123"));

        User loggedUser = authService.getLoggedUser();
        assertNotNull(loggedUser);
        assertEquals("testUser5", loggedUser.name());
    }

    @Test
    void testLogInTwice() throws UserAlreadyExistsException {
        authService.register("testUser6", "password123");
        assertDoesNotThrow(() -> authService.logIn("testUser6", "password123"));

        LogInException exception = assertThrows(LogInException.class, () -> authService.logIn("testUser6", "password1234"));

        assertEquals(IncorrectPasswordException.class, exception.getClass());
    }
}
