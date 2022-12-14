package org.example.smartStore.store.Service;

import org.example.smartStore.store.DAO.UserDAO;
import org.example.smartStore.store.DTO.UserDTO;
import org.example.smartStore.store.Entity.User;
import org.example.smartStore.store.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements iUserService{

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO){this.userDAO = userDAO;}

    @Override
    public UserVO login(String userID, String userPassword) {
        UserDTO userDTO = new UserDTO(userID,userPassword);
        if (userDTO==null)return null;

        User user = userDAO.selectByID(userDTO.getUserID());
        if(user == null || user.getUserPassword()==null)return null;
        if(user.getUserPassword().equals(userDTO.getUserPassword())){
            UserVO userVO = new UserVO(user);
            userVO = userVO.toUserInfo(user);
            return userVO;
        }
        return null;
    }

    @Override
    public boolean checkIDExist(String userID){
        User user = userDAO.selectByID(userID);
        if(user==null){
            return true;
        }else return false;
    }

    @Override
    public boolean doSignUp(String userID,String userPassword,String userEmail,String userName,String userStoreName){
        return userDAO.doSignUp(userID,userPassword,userName,userEmail,userStoreName)>0;
    }

    @Override
    public boolean deleteUser(String userID){
        return userDAO.deleteUser(userID)>0;
    }

    @Override
    public boolean updateUser(User user,String beforePassword){
        boolean result = false;
        if (userDAO.selectByID(user.getUserID()).getUserPassword().equals(beforePassword)){
            if (userDAO.updateUser(user)>0){
                result = true;
            }
        }
        return result;
    }

    @Override
    public User getUserInfo(String userID){
        return userDAO.selectByID(userID);
    }

}
