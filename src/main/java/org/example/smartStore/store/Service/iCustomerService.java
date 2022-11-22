package org.example.smartStore.store.Service;

import org.example.smartStore.store.DAO.CustomerDAO;
import org.example.smartStore.store.DTO.CustomerDTO;
import org.example.smartStore.store.Entity.Customer;
import org.example.smartStore.store.Entity.CustomerWithGrade;

import java.util.List;

public interface iCustomerService {
    List<CustomerDTO> getCustomerList(String userID, CustomerDAO customerDAO);

    Customer selectCustomer(String userID,String customerID,CustomerDAO customerDAO);

    boolean addCustomer(Customer customer,CustomerDAO customerDAO);
    boolean updateCustomer(Customer customer, CustomerDAO customerDAO);
    boolean deleteCustomer(Customer customer, CustomerDAO customerDAO);
    boolean deleteAllCustomers(String userID, CustomerDAO customerDAO);
    List<CustomerWithGrade> listWithGrade(List<CustomerDTO> customerDTOList, ParameterService parameterService, String userID);
}
