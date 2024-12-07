package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testChangePassword() {
        User user = new User("myUsername", "oldPassword", "myemail@example.com");

        // Test correct password change
        user.changePassword("oldPassword", "newPassword");
        assertEquals("newPassword", user.getPassword());

        // Test incorrect old password
        try {
            user.changePassword("wrongPassword", "newPassword");
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Old password is incorrect.", e.getMessage());
        }

        // Test new password cannot be null or empty
        try {
            user.changePassword("newPassword", null);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("New password cannot be null or empty.", e.getMessage());
        }
    }

    @Test
    public void testChangeEmail() {
        User user = new User("myUsername", "myPassword", "myemail@example.com");

        // Test correct email change
        user.changeEmail("newemail@example.com");
        assertEquals("newemail@example.com", user.getEmail());

        // Test new email cannot be null or empty
        try {
            user.changeEmail(null);
            fail("Expected IllegalArgumentException was not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("New email cannot be null or empty.", e.getMessage());
        }
    }
}