package org.example.smartStore.store.DTO;

import org.example.smartStore.store.Entity.User;
import org.example.smartStore.store.VO.UserVO;

public class UserDTO {
    private String userName;
    private String userID;
    private String userPassword;
    private String userEmail;
    private String userStoreName;

    public UserDTO(String userName, String userID, String userPassword, String userEmail, String userStoreName) {
        this.userName = userName;
        this.userID = userID;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userStoreName = userStoreName;
    }

    public User toEntity(){
        return new User(userName,userID,userPassword,userEmail,userStoreName);
    }
    public UserVO toVO(){
        return new UserVO(userName,userID,userPassword,userEmail,userStoreName);
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
}
