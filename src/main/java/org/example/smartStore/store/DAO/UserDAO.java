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
    private static final String USER_INSERT = "INSERT INTO USERS VALUES (?,?,?,?,?)";
//    private static final String USER_INSERT = "INSERT INTO USERS VALUES ('아이디','비밀번호','이메일','이름','스토어이름')";
    private static final String USER_DELETE = "DELETE FROM USERS WHERE USER_ID = ?";
    private static final String USER_UPDATE = "UPDATE USERS SET USER_PASSWORD = ? ,USER_EMAIL = ? ,USER_NAME = ?,USER_STORE_NAME = ? WHERE USER_ID= ?";


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

    @Override
    public int doSignUp(String userID,String userPassword,String userName,String userEmail,String userStoreName){
        int res =0;
        try{
            connection = jdbcMgr.getConnection();
            statement = connection.prepareStatement(USER_INSERT);
            statement.setString(1, userID);
            statement.setString(2, userPassword);
            statement.setString(3, userEmail);
            statement.setString(4, userName);
            statement.setString(5, userStoreName);
            res = statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            jdbcMgr.close(resultSet,statement,connection);
        }
        return res;
    }

    @Override
    public int deleteUser(String userID){
        int res =0;
        try {connection = jdbcMgr.getConnection();
            statement = connection.prepareStatement(USER_DELETE);
            statement.setString(1, userID);
            res = statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }finally {
            jdbcMgr.close(resultSet,statement,connection);
        }return res;
    }

    @Override
    public int updateUser(User user){//'아이디','비밀번호','이메일','이름','스토어이름
        int res =0;
        try{
            connection = jdbcMgr.getConnection();
            statement = connection.prepareStatement(USER_UPDATE);
            statement.setString(1,user.getUserPassword());
            statement.setString(2,user.getUserEmail());
            statement.setString(3,user.getUserName());
            statement.setString(4, user.getUserStoreName());
            statement.setString(5,user.getUserID());
            res = statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcMgr.close(resultSet,statement,connection);
        }return res;
    }

}
