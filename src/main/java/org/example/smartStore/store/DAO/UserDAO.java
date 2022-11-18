package org.example.smartStore.store.DAO;

import org.example.smartStore.store.Entity.User;
import org.example.smartStore.store.database.JDBCMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@Repository
public class UserDAO implements iUserDAO{
    private JDBCMgr jdbcMgr;

    @Autowired
    public UserDAO(JDBCMgr jdbcMgr){
        this.jdbcMgr = jdbcMgr;
    }
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    private static final String USER_SELECT = "SELECT * FROM USERS WHERE USER_ID = ?";

    @Override
    public User selectByID(String userID) {
        User user = null;
        try {
            connection = jdbcMgr.getConnection();
            statement = connection.prepareStatement(USER_SELECT);
            statement.setString(1, userID);

            resultSet = statement.executeQuery();

            if(resultSet.next()){
                String userIDFromDB = resultSet.getString("USER_ID");
                String userPassword = resultSet.getString("USER_PASSWORD");
                String userEmail = resultSet.getString("USER_EMAIL");
                String userName = resultSet.getString("USER_NAME");
                String userStoreName = resultSet.getString("USER_STORE_NAME");
                user = new User(userName,userIDFromDB,userPassword,userEmail,userStoreName);
            }
        } catch (SQLException e) {
           e.printStackTrace();
        }finally {
            jdbcMgr.close(resultSet,statement,connection);
        }
        return user;
    }
}
