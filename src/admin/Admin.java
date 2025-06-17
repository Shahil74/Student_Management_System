package admin;

import java.io.Serializable;

public class Admin implements Serializable{
	private static final long serialVersionUID = 1L;
    private String username;
    private String password;

    public Admin(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty!");
        }
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty!");
        }
        this.password = password;
    }
}
