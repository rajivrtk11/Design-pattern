package genericContactList.models;

public class User {
    private final String userId;
    private String name;
    private String profession;

    public User(String userId, String name, String profession) {
        this.userId = userId;
        this.name = name;
        this.profession = profession;
    }

    public String getUserId() {
        return userId;
    }
}

