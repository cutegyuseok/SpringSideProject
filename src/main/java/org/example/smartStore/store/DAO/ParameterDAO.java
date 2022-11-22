package org.example.smartStore.store.DAO;

import org.example.smartStore.store.Entity.Customer;
import org.example.smartStore.store.Entity.Parameter;
import org.example.smartStore.store.database.JDBCMgr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ParameterDAO implements iParameterDAO{

    @Autowired
    private JDBCMgr jdbcMgr;

//    private static final String CUSTOMER_UPDATE = "UPDATE CUSTOMERS SET CUSTOMER_NAME = ? ,CUSTOMER_SPENT_MONEY = ? ,CUSTOMER_PURCHASE_COUNT = ? WHERE CUSTOMER_ID= ?";


    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    private static final String PARAMETER_SELECT_ALL = "SELECT * FROM PARAMETER WHERE USER_ID = ? ORDER BY MINIMUM_SPENT_MONEY";
    private static final String PARAMETER_INSERT = "INSERT INTO PARAMETER VALUES (?,?,?,?)";
    private static final String PARAMETER_DELETE = "DELETE FROM PARAMETER WHERE GRADE = ? AND USER_ID = ?";
    private static final String PARAMETER_DELETE_ALL = "DELETE FROM PARAMETER WHERE USER_ID = ?";
    private static final String PARAMETER_UPDATE = "UPDATE PARAMETER SET MINIMUM_SPENT_MONEY = ? , MINIMUM_PURCHASE_COUNT =? WHERE USER_ID = ? AND GRADE = ?";
//    INSERT INTO PARAMETER VALUES ('b','최고급',300000,10);
/*CREATE TABLE PARAMETER(
            USER_ID VARCHAR(40) NOT NULL,
    GRADE VARCHAR(40) NOT NULL,
    MINIMUM_SPENT_MONEY INT NOT NULL,
    MINIMUM_PURCHASE_COUNT INT NOT NULL,
    FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
            );*/

    public List<Parameter> getAllParameter(String userID){
        List<Parameter> parameterList = new LinkedList<>();
        try {
            connection = jdbcMgr.getConnection();
            statement = connection.prepareStatement(PARAMETER_SELECT_ALL);
            statement.setString(1, userID);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String grade = resultSet.getString("GRADE");
                int minimumSpentMoney = resultSet.getInt("MINIMUM_SPENT_MONEY");
                int minimumPurchaseCount = resultSet.getInt("MINIMUM_PURCHASE_COUNT");
                parameterList.add(new Parameter(userID,grade,minimumSpentMoney,minimumPurchaseCount));
            }
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }finally {
            jdbcMgr.close(resultSet,statement,connection);
        }
        return parameterList;
    }

    public int insertParameter(Parameter parameter){
        int res =0;
        try{
            connection = jdbcMgr.getConnection();
            statement = connection.prepareStatement(PARAMETER_INSERT);
            statement.setString(1, parameter.getUserID());
            statement.setString(2,parameter.getGrade());
            statement.setInt(3,parameter.getMinimumSpentMoney());
            statement.setInt(4,parameter.getMinimumPurchaseCount());
            res = statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }finally {
            jdbcMgr.close(resultSet,statement,connection);
        }
        return res;
    }

    public int deleteParameter(String grade,String userID){
        int res = 0;
        try {
            connection = jdbcMgr.getConnection();
            statement = connection.prepareStatement(PARAMETER_DELETE);
            statement.setString(1,grade);
            statement.setString(2,userID);
            res = statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }finally {
            jdbcMgr.close(resultSet,statement,connection);
        }
        return res;
    }

    public int updateParameter(Parameter parameter){
        int res =0;
        try {
            connection = jdbcMgr.getConnection();
            statement = connection.prepareStatement(PARAMETER_UPDATE);
            statement.setInt(1, parameter.getMinimumSpentMoney());
            statement.setInt(2, parameter.getMinimumPurchaseCount());
            statement.setString(3, parameter.getUserID());
            statement.setString(4, parameter.getGrade());
            res = statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
        }finally {
            jdbcMgr.close(resultSet,statement,connection);
        }return res;
    }

    public int deleteAllParameter(String userID){
        int res = 0;
        try {
            connection = jdbcMgr.getConnection();
            statement = connection.prepareStatement(PARAMETER_DELETE_ALL);
            statement.setString(1,userID);
            res = statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println(e);
            res = -1;
        }finally {
            jdbcMgr.close(resultSet,statement,connection);
        }
        return res;
    }



}
