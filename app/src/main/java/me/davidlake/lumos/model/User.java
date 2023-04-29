package me.davidlake.lumos.model;

public class User {
    private int id;
    private String email;
    private String password;

    // CONSTRUCTOR

    public User() {}
    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    // GETTERS

    public int getId() { return this.id; }
    public String getEmail() { return this.email; }
    public String getPassword() { return this.password; }

    // SETTERS

    public void setId(int id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}
