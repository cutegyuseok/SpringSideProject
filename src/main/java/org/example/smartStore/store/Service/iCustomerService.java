package org.example.smartStore.store.Service;

import org.example.smartStore.store.DAO.CustomerDAO;
import org.example.smartStore.store.DTO.CustomerDTO;
import org.example.smartStore.store.Entity.Customer;
import org.example.smartStore.store.Entity.CustomerWithGrade;

import java.util.List;

public interface iCustomerService {
    List<CustomerDTO> customerList(String userID );

//    Customer selectCustomer(String userID,String customerID,CustomerDAO customerDAO);

    boolean addCustomer(Customer customer );
    boolean updateCustomer(Customer customer );
    boolean deleteCustomer(Customer customer );
    boolean deleteAllCustomers(String userID );
    List<CustomerWithGrade> listWithGrade(List<CustomerDTO> customerDTOList, ParameterService parameterService, String userID);
}
