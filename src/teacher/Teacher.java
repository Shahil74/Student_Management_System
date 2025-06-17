package teacher;

import java.io.Serializable;

public class Teacher implements Serializable{
    private static int idCounter = 100;
    private int tid;
    private String username;
    private String password;

    public Teacher(String username, String password) {
        this.tid = idCounter++;
        setUsername(username);
        setPassword(password);
    }

    public int getTid() {
        return tid;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
    	if(username.isEmpty() || username.trim().isEmpty()) {
    		throw new IllegalArgumentException("Username cannot be empty");
    	}
    	this.username=username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
    	if(password.isEmpty() || password.trim().isEmpty()) {
    		throw new IllegalArgumentException("Password cannot be empty");
    	}
    	this.password=password;
    }

    @Override
    public String toString() {
        return "Teacher [ID: " + tid + ", Username: " + username + ", Password: " + password + "]";
    }
}
