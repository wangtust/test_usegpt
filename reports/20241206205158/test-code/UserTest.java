package net.mooctest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User("testUser", "password123", "test@example.com");
    }

    @Test
    public void testGetters() {
        assertEquals("testUser", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals("test@example.com", user.getEmail());
    }

    @Test
    public void testChangePasswordValid() {
        user.changePassword("password123", "newPassword123");
        assertEquals("newPassword123", user.getPassword());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangePasswordInvalidOldPassword() {
        user.changePassword("wrongPassword", "newPassword123");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangePasswordInvalidNewPassword() {
        user.changePassword("password123", null);
    }

    @Test
    public void testChangeEmailValid() {
        user.changeEmail("new@example.com");
        assertEquals("new@example.com", user.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeEmailInvalid() {
        user.changeEmail(null);
    }

    @Test
    public void testToString() {
        assertEquals("User{username='testUser', email='test@example.com'}", user.toString());
    }
}