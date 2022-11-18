package org.example.smartStore.store.Service;

import org.example.smartStore.store.DTO.UserDTO;
import org.example.smartStore.store.Entity.User;

public interface iUserService {

    User login(String userID, String userPassword);

}
