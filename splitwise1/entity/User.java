package splitwise1.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {
    String userId;
    String name;
    String email;
    String mobile;
    Map<String, Expense> lendToMap;

    public User(String userId, String name, String email, String mobile) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        lendToMap = new HashMap<>();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Map<String, Expense> getLendToMap() {
        return lendToMap;
    }

    public void setLendToMap(Map<String, Expense> lendToMap) {
        this.lendToMap = lendToMap;
    }
}
