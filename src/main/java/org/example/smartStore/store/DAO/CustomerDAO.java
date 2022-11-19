package org.example.smartStore.store.DAO;

import org.example.smartStore.store.Entity.Customer;
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
public class CustomerDAO {

    private JDBCMgr jdbcMgr;

    @Autowired
    public CustomerDAO(JDBCMgr jdbcMgr){
        this.jdbcMgr = jdbcMgr;
    }
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    private static final String CUSTOMER_SELECT_ALL_BY_USER_ID = "SELECT * FROM CUSTOMERS WHERE USER_ID = ?";
    private static final String CUSTOMER_SELECT_BY_CUSTOMER_ID = "SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID = ?";

    public List<Customer> selectAll(String userID){
        List<Customer> customerList = new LinkedList<>();

        try {
            connection = jdbcMgr.getConnection();
            statement = connection.prepareStatement(CUSTOMER_SELECT_ALL_BY_USER_ID);
            statement.setString(1,userID);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                String customerID = resultSet.getString("CUSTOMER_ID");
                String customerName = resultSet.getString("CUSTOMER_NAME");
                int customerSpentMoney = resultSet.getInt("CUSTOMER_SPENT_MONEY");
                int customerPurchaseCount = resultSet.getInt("CUSTOMER_PURCHASE_COUNT");
                customerList.add(new Customer(userID,customerID,customerName,customerSpentMoney,customerPurchaseCount));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcMgr.close(resultSet,statement,connection);
        }
        return customerList;
    }

}