package org.example.smartStore.store.DAO;

import org.example.smartStore.store.Entity.Customer;
import org.example.smartStore.store.VO.CustomerVO;
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
public class CustomerDAO implements iCustomerDAO{

    private JDBCMgr jdbcMgr;

    @Autowired
    public CustomerDAO(JDBCMgr jdbcMgr){
        this.jdbcMgr = jdbcMgr;
    }
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;


    private static final String CUSTOMER_SELECT_ALL_BY_USER_ID = "SELECT * FROM CUSTOMERS WHERE USER_ID = ?";
    private static final String CUSTOMER_SELECT_BY_CUSTOMER_ID = "SELECT * FROM CUSTOMERS WHERE USER_ID = ? AND CUSTOMER_ID = ?";
    private static final String CUSTOMER_INSERT = "INSERT INTO CUSTOMERS VALUES (?,?,?,?,?)";



    @Override
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
        } finally {
            jdbcMgr.close(resultSet,statement,connection);
        }
        return customerList;
    }

    @Override
    public Customer select(String userID, String customerID) {
        Customer customer = null;
        try{
            connection = jdbcMgr.getConnection();
            statement = connection.prepareStatement(CUSTOMER_SELECT_BY_CUSTOMER_ID);
            statement.setString(1,userID);
            statement.setString(2,customerID);
            resultSet = statement.executeQuery();
            customer = new Customer(userID, resultSet.getString("CUSTOMER_ID"),resultSet.getString("CUSTOMER_NAME"), resultSet.getInt("CUSTOMER_SPENT_MONEY"), resultSet.getInt("CUSTOMER_PURCHASE_COUNT"));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcMgr.close(resultSet,statement,connection);
        }
        return customer;
    }

    @Override
    public int addCustomer(Customer customer) {
        int res =0;
        try {
            connection = jdbcMgr.getConnection();
            statement = connection.prepareStatement(CUSTOMER_INSERT);
            statement.setString(1,customer.getUserID());
            statement.setString(2,customer.getCustomerID());
            statement.setString(3,customer.getCustomerName());
            statement.setInt(4,customer.getCustomerSpentMoney());
            statement.setInt(5,customer.getCustomerPurchaseCount());
            res = statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            jdbcMgr.close(resultSet,statement,connection);
        }
        return res;
    }
}
