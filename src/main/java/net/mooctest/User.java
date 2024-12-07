package net.mooctest;

public class User {

    private String username;
    private String password;
    private String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (!this.password.equals(oldPassword)) {
            throw new IllegalArgumentException("Old password is incorrect.");
        }
        if (newPassword == null || newPassword.isEmpty()) {
            throw new IllegalArgumentException("New password cannot be null or empty.");
        }
        this.password = newPassword;
    }

    public void changeEmail(String newEmail) {
        if (newEmail == null || newEmail.isEmpty()) {
            throw new IllegalArgumentException("New email cannot be null or empty.");
        }
        this.email = newEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}