package edu.upc.dsa.models;

import edu.upc.dsa.annotations.CustomAnnotation;
import edu.upc.dsa.util.RandomUtils;
import java.util.List;


public class User {
    @CustomAnnotation("id_exclude")
    private String id;

    private String username;
    private String password;
    private String isAdmin;
    private String fullName;
    private String email;
    private int age;
    private String profilePicture;
    private int coins;
    private List<Badge> badges;

    public User() {
        this.setId(RandomUtils.getId());
        this.isAdmin = "notadmin";
        this.coins = 0;
    }

    public User(String username, String password, String isAdmin) {
        this();
        this.setUsername(username);
        this.setPassword(password);
        this.isAdmin = isAdmin;
    }

    public User(String username, String password, String isAdmin, String fullName, String email, int age, String profilePicture, int coins) {
        this(username, password, isAdmin);
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.profilePicture = profilePicture;
        this.coins = coins;
    }

    // Getters and Setters
    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String admin) {
        isAdmin = admin;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public boolean isValidPassword(String password) {
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(regex);
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void addBadges(Badge badge) {
        this.badges.add(badge);
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", fullName=" + fullName +
                ", email=" + email + ", age=" + age + ", profilePicture=" + profilePicture + ", coins=" + coins + "]";
    }
}