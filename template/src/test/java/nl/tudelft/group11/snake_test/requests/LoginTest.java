package nl.tudelft.group11.snake_test.requests;

import nl.tudelft.group11.snake.requests.Login;
import nl.tudelft.group11.snake.requests.Signup;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
