package org.example.smartStore.store.Service;

import org.example.smartStore.store.DAO.UserDAO;
import org.example.smartStore.store.DTO.UserDTO;
import org.example.smartStore.store.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements iUserService{

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO){this.userDAO = userDAO;}

    @Override
    public User login(String userID, String userPassword) {
        UserDTO userDTO = new UserDTO(userID,userPassword);
        if (userDTO==null)return null;

        User user = userDAO.selectByID(userDTO.getUserID());
        if(user == null || user.getUserPassword()==null)return null;
        if(user.getUserPassword().equals(userDTO.getUserPassword())){
            return user;
        }
        return null;
    }
}
