package org.example.smartStore.store.DAO;

import org.example.smartStore.store.Entity.User;

public interface iUserDAO {
    User selectByID(String userID);
    int doSignUp(String userID,String userPassword,String userName,String userEmail,String userStoreName);

    int updateUser(User user);
    int deleteUser(String userID);
}
