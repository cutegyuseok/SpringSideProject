package org.example.smartStore.store.VO;

public class UserVO {
    private String userName;
    private String userID;
    private String userPassword;
    private String userEmail;
    private String userStoreName;

    public UserVO(String userName, String userID, String userPassword, String userEmail, String userStoreName) {
        this.userName = userName;
        this.userID = userID;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userStoreName = userStoreName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserStoreName() {
        return userStoreName;
    }
}
