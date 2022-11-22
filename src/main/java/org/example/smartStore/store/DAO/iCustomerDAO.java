package org.example.smartStore.store.DAO;

import org.example.smartStore.store.DTO.CustomerDTO;
import org.example.smartStore.store.Entity.Customer;


import java.util.List;

public interface iCustomerDAO {
    List<Customer> selectAll(String userID);
    CustomerDTO select(String userID, String customerID);


    int addCustomer(Customer customer);
    int updateCustomer(Customer customer);
    int deleteCustomer(Customer customer);
    int deleteAllCustomers(String userID);

}
