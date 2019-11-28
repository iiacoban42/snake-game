package nl.tudelft.group11.snake_test.requests;

import org.junit.jupiter.api.Test;
import nl.tudelft.group11.snake.requests.Signup;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignupTest {

    @Test
    void testUsernameNull() {
        Signup s = new Signup(null, "password");
        s.execute();

        assertTrue(s.hasErrors());
        assertTrue(s.getErrors().size() > 0);
    }

    @Test
    void testUsernameEmpty() {
        Signup s = new Signup("", "password");
        s.execute();

        assertTrue(s.hasErrors());
        assertTrue(s.getErrors().size() > 0);
    }

    @Test
    void testPasswordNull() {
        Signup s = new Signup("username1", null);
        s.execute();

        assertTrue(s.hasErrors());
        assertTrue(s.getErrors().size() > 0);
    }

    @Test
    void testPasswordEmpty() {
        Signup s = new Signup("username2", "");
        s.execute();

        assertTrue(s.hasErrors());
        assertTrue(s.getErrors().size() > 0);
    }

    @Test
    void testPasswordTooShort() {
        Signup s = new Signup("username3", "abc");
        s.execute();

        assertTrue(s.hasErrors());
        assertTrue(s.getErrors().size() > 0);
    }

    @Test
    void testCorrectSignup() {
        Signup s = new Signup("username4", "correct_password");
        s.execute();

        assertFalse(s.hasErrors());
    }

}
