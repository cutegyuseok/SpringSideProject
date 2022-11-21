package org.example.smartStore.store.DAO;

import org.example.smartStore.store.Entity.Customer;


import java.util.List;

public interface iCustomerDAO {
    List<Customer> selectAll(String userID);


    int addCustomer(Customer customer);

}
