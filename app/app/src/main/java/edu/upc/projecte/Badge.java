package edu.upc.projecte;

public class Badge {
    private String name;
    private String avatar;

    public Badge(String name, String avatar) {
        this.setName(name);
        this.setAvatar(avatar);
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getName() {
        return name;
    }
}

