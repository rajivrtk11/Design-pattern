package Splitwise.entity;

import java.util.HashMap;

public class User {
    private String userId;
    private String name;
    private String email;
    private String mobileNumber;
    private HashMap<String, Expense> lendToMap;

    public User(String userId, String name, String email, String mobileNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.lendToMap = new HashMap<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", lendToMap=" + lendToMap +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public HashMap<String, Expense> getLendToMap() {
        return lendToMap;
    }

    public void setLendToMap(HashMap<String, Expense> lendToMap) {
        this.lendToMap = lendToMap;
    }
}
