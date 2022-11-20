package org.example.smartStore.store.Service;

import org.example.smartStore.store.DAO.CustomerDAO;
import org.example.smartStore.store.DTO.CustomerDTO;
import org.example.smartStore.store.Entity.Customer;

import java.util.List;

public interface iCustomerService {
    List<CustomerDTO> getCustomerList(String userID, CustomerDAO customerDAO);

    Customer selectCustomer(String userID,String customerID,CustomerDAO customerDAO);
}
