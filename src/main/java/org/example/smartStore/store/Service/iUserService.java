package org.example.smartStore.store.Service;

import org.example.smartStore.store.DTO.UserDTO;

public interface iUserService {

    UserDTO login(String userID,String userPassword);

}
