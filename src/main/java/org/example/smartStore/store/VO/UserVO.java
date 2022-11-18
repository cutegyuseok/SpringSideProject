package org.example.smartStore.store.VO;

import org.example.smartStore.store.Entity.User;

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
    public UserVO(String userID, String userName, String userStoreName){
        this.userID = userID;
        this.userName = userName;
        this.userStoreName = userStoreName;
    }
    public UserVO(User user){
        this.userName = user.getUserName();
        this.userID = user.getUserID();
        this.userPassword = user.getUserPassword();
        this.userEmail = user.getUserEmail();
        this.userStoreName = user.getUserStoreName();
    }

    public UserVO toUserInfo(User user){
       UserVO userVO= new UserVO(user.getUserID(),user.getUserName(),user.getUserStoreName());
       return userVO;
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
