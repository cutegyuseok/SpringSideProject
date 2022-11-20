package org.example.smartStore.store.Service;

import org.example.smartStore.store.DTO.UserDTO;
import org.example.smartStore.store.Entity.User;
import org.example.smartStore.store.VO.UserVO;

public interface iUserService {

    UserVO login(String userID, String userPassword);
    boolean checkIDExist(String userID);


}
