package nl.tudelft.group11.snake.requests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


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
    void testPasswordTooShort2() {
        Signup s = new Signup("username4", "abcdefg");
        s.execute();

        assertTrue(s.hasErrors());
        assertTrue(s.getErrors().size() > 0);
    }

    @Test
    void testNoRunningServer() {
        Signup s = new Signup("username5", "correct_password");
        s.execute();

        assertTrue(s.hasErrors());
        assertTrue(s.getErrors().size() > 0);
        assertTrue(s.getErrors().contains("Couldn't connect to the server"));
    }

    @Test
    void testErrorsBeforeExecution() {
        Signup s = new Signup("username5", "correct_password");
        assertFalse(s.hasErrors());
    }

    @Test
    void testResultBeforeExecution() {
        Signup s = new Signup("username5", "correct_password");
        assertNull(s.getResult());
    }
}
