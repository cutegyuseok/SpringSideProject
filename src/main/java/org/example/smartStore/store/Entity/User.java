package org.example.smartStore.store.Entity;

import java.util.Objects;

public class User {

    private String userName;
    private String userID;
    private String userPassword;
    private String userEmail;
    private String userStoreName;

    public User(String userName, String userID, String userPassword, String userEmail, String userStoreName) {
        this.userName = userName;
        this.userID = userID;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userStoreName = userStoreName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserStoreName() {
        return userStoreName;
    }

    public void setUserStoreName(String userStoreName) {
        this.userStoreName = userStoreName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(userName, user.userName)) return false;
        if (!Objects.equals(userID, user.userID)) return false;
        if (!Objects.equals(userPassword, user.userPassword)) return false;
        if (!Objects.equals(userEmail, user.userEmail)) return false;
        return Objects.equals(userStoreName, user.userStoreName);
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (userID != null ? userID.hashCode() : 0);
        result = 31 * result + (userPassword != null ? userPassword.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userStoreName != null ? userStoreName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "USER{" +
                "userName='" + userName + '\'' +
                ", userID='" + userID + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userStoreName='" + userStoreName + '\'' +
                '}';
    }
}
