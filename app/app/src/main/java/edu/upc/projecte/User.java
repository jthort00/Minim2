package edu.upc.projecte;

public class User {
    private String id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private int age;

    private int coins;


    // Default constructor
    public User() {}

    // Constructor with all parameters
    public User(String id, String username, String password, String fullName, String email, int age) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.coins = 0;
    }

    // Constructor with username and password
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void setAge(int age) {
        this.age = age;
    }
}