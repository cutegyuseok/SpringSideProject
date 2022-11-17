package org.example.smartStore.store.DAO;

import org.example.smartStore.store.Entity.User;

public interface iUserDAO {
    User select(String userID);
}
