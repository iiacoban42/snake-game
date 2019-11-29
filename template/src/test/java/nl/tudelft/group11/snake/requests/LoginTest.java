package nl.tudelft.group11.snake.requests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LoginTest {

    @Test
    void testUsernameNull() {
        Login l = new Login(null, "password");
        l.execute();

        assertTrue(l.hasErrors());
        assertTrue(l.getErrors().size() > 0);
    }

    @Test
    void testUsernameEmpty() {
        Login l = new Login("", "password");
        l.execute();

        assertTrue(l.hasErrors());
        assertTrue(l.getErrors().size() > 0);
    }

    @Test
    void testPasswordNull() {
        Login l = new Login("username", null);
        l.execute();

        assertTrue(l.hasErrors());
        assertTrue(l.getErrors().size() > 0);
    }

    @Test
    void testPasswordEmpty() {
        Login l = new Login("username", "");
        l.execute();

        assertTrue(l.hasErrors());
        assertTrue(l.getErrors().size() > 0);
    }

    @Test
    void testNoRunningServer() {
        Login l = new Login("username", "correct_password");
        l.execute();

        assertTrue(l.hasErrors());
        assertTrue(l.getErrors().size() > 0);
        assertTrue(l.getErrors().contains("Couldn't connect to the server"));
    }
}
