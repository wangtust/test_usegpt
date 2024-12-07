package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testChangePassword() {
        User user = new User("testUser", "oldPassword", "test@example.com");
        user.changePassword("oldPassword", "newPassword");

        assertEquals("newPassword", user.getPassword());
    }

    @Test
    public void testChangeEmail() {
        User user = new User("testUser", "password", "old@example.com");
        user.changeEmail("new@example.com");

        assertEquals("new@example.com", user.getEmail());
    }

    @Test
    public void testToString() {
        User user = new User("testUser", "password", "test@example.com");

        String expected = "User{username='testUser', email='test@example.com'}";
        assertEquals(expected, user.toString());
    }
}